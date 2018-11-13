package com.oscar.opm.gef.editor.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.NodeEditPart;

import com.oscar.opm.model.OPMLink;
import com.oscar.opm.model.OPMNode;
import com.oscar.opm.gef.editor.figure.OPMNodeFigure;
import com.oscar.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.oscar.opm.gef.editor.policy.OPMNodeComponentEditPolicy;
import com.oscar.opm.gef.editor.policy.OPMNodeGraphicalNodeEditPolicy;

public abstract class OPMNodeEditPart extends AbstractGraphicalEditPart implements NodeEditPart {
	
	private OPMNodeAdapter adapter;
	
	public class OPMNodeAdapter implements Adapter{
		@Override
		public void notifyChanged(Notification notification) {
			refresh();
		}
		
		@Override
		public Notifier getTarget() {
			return (OPMNode)getModel();
		}
		
		@Override
		public void setTarget(Notifier newTarget) {
			//Do nothing
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type.equals(OPMNode.class);
		}
		
	}

	public OPMNodeEditPart() {
		super();
		adapter = new OPMNodeAdapter();
	}

	@Override
	protected List<OPMLink> getModelSourceConnections() {
		OPMNode model = (OPMNode)getModel();
		return model.getOutgoingLinks();
	}

	@Override
	protected List<OPMLink> getModelTargetConnections() {
		OPMNode model = (OPMNode)getModel();
		return model.getIncomingLinks();
	}

	@Override
	public void activate() {
		if(!isActive()) {
			((OPMNode)getModel()).eAdapters().add(adapter);
		}
		super.activate();
	}

	@Override
	public void deactivate() {
		if(isActive()) {
			((OPMNode)getModel()).eAdapters().remove(adapter);
		}
		super.deactivate();
	}
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new OPMNodeComponentEditPolicy());
        installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new OPMNodeGraphicalNodeEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new OPMContainerXYLayoutPolicy());
	}
	
	@Override
	protected List getModelChildren() {
		OPMNode model = (OPMNode) getModel();
		return Collections.unmodifiableList(model.getNodes());
	}
	
	@Override
    public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
    	return ((OPMNodeFigure)getFigure()).getSourceConnectionAnchor();
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
    	return ((OPMNodeFigure)getFigure()).getTargetConnectionAnchor();
    }

    @Override
    public ConnectionAnchor getSourceConnectionAnchor(Request request) {
    	return ((OPMNodeFigure)getFigure()).getSourceConnectionAnchor();
    }

    @Override
    public ConnectionAnchor getTargetConnectionAnchor(Request request) {
    	return ((OPMNodeFigure)getFigure()).getTargetConnectionAnchor();
    }
}
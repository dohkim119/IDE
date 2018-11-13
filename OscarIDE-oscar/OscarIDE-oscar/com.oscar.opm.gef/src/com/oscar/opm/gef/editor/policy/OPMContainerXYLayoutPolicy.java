package com.oscar.opm.gef.editor.policy;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import com.oscar.opm.model.OPMContainer;
import com.oscar.opm.model.OPMNode;
import com.oscar.opm.model.OPMObject;
import com.oscar.opm.model.OPMObjectProcessDiagram;
import com.oscar.opm.model.OPMProcess;
import com.oscar.opm.model.OscarCode;
import com.oscar.opm.gef.editor.part.OPMStructuralLinkAggregatorEditPart;
import com.oscar.opm.gef.editor.policy.OPMContainerXYLayoutPolicy;
import com.oscar.opm.gef.editor.command.OPMNodeCreateCommand;
import com.oscar.opm.gef.editor.command.OscarCodeFileLocateCommand;
import com.oscar.opm.gef.editor.command.OPMNodeChangeConstraintCommand;


public class OPMContainerXYLayoutPolicy extends XYLayoutEditPolicy {
	
	private static final Dimension DEFAULT_THING_DIMENSION = new Dimension(50,50);
	
	/**
	 * Command created top change the constraints of a {@link OPMNode} instance.
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart child,Object constraint) 
	{
		OPMNodeChangeConstraintCommand command = new OPMNodeChangeConstraintCommand();
		command.setNode((OPMNode) child.getModel());
		command.setNewConstraint((Rectangle) constraint);
		return command;
	}
	
	/**
	 * Command created to add new nodes to the OPD.
	 */
	@Override 
	protected Command getCreateCommand(CreateRequest request) 
	{
		Command retVal = null;
		if(request.getNewObjectType().equals(OscarCode.class)) {
			retVal = getNodeCreateCommand(request);
		}
		else if(request.getNewObjectType().equals(OPMObject.class) || request.getNewObjectType().equals(OPMProcess.class)){
			retVal = getNodeCreateCommand(request);
		}
		return retVal;
	}
	
	private Command getNodeCreateCommand(CreateRequest request)
	{
		OPMNodeCreateCommand command = new OPMNodeCreateCommand();
		Rectangle constraints = (Rectangle) getConstraintFor(request);
		command.setConstraints(new Rectangle(constraints.getLocation(),DEFAULT_THING_DIMENSION));
		if(getHost().getModel() instanceof OPMObjectProcessDiagram) command.setContainer((OPMContainer) getHost().getModel()); 
		else command.setContainer((OPMContainer) ((OPMNode) getHost().getModel()).getOpd());
		//command.setContainer((OPMContainer) getHost().getModel());  
		// <- make contained object. we don't have to use this functionality, so I commentlize this code. if you want use this,
		// uncommentlize this code and delete if~else code right above.
		command.setNode((OPMNode)(request.getNewObject()));
		return command;
	}
	
	
	/**
	 * The superclass implementation calls 
	 * {@link OPMContainerXYLayoutPolicy#getResizeChildrenCommand(ChangeBoundsRequest) getResizeChildrenCommand()}
	 *  by default. This is not good in our case since we want to disallow resizing of 
	 *  {@link OPMStructuralLinkAggregatorEditPart} while allowing to move them. Therefore
	 *  we had to override the implementation.
	 *  It creates a {@link Command} that can be used to move a children of the policy's owner.
	 *  @return a {@link Command} used to move children of the host {@link EditPart}. 
	 */
	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return getChangeConstraintCommand((ChangeBoundsRequest) request);
	}
	
	/**
	 * Creates a {@link Command} to resize children of the host {@link EditPart}.
	 * The functions checks that the children don't contain any {@link OPMStructuralLinkAggregatorEditPart}
	 * instances which cannot be resized.
	 * @return a {@link Command} to resize children of the {@link EditPart}.
	 */
	@Override
	protected Command getResizeChildrenCommand(ChangeBoundsRequest request) {
		for(Object editPart : request.getEditParts()) {
			if(editPart instanceof OPMStructuralLinkAggregatorEditPart) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return getChangeConstraintCommand(request);
	}	
}

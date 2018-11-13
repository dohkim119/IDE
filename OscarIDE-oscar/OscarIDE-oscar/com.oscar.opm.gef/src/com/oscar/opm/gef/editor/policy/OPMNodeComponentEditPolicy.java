package com.oscar.opm.gef.editor.policy;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.oscar.opm.model.OPMNode;
import com.oscar.opm.model.OPMLink;
import com.oscar.opm.gef.action.ResizeToContentsAction;
import com.oscar.opm.gef.editor.command.OPMNodeChangeConstraintCommand;
import com.oscar.opm.gef.editor.command.OPMNodeDeleteCommand;
import com.oscar.opm.gef.editor.figure.OPMNodeFigure;
import com.oscar.opm.gef.editor.part.OPMNodeEditPart;

/**
 * {@link EditPolicy} used for delete requests.
 *
 */

public class OPMNodeComponentEditPolicy extends ComponentEditPolicy {
	
	private static final int INSETS = 20;

    /**
     * Create a command to delete a node. When a node is deleted all incoming
     * and outgoing links are also deleted (functionality provided by the
     * command). When a {@link OPMThing} node is deleted, there is special
     * treatment for structural links that start and end at this node. If this
     * node is source for a structural link, the
     * {@link OPMStructuralLinkAggregator} of this link must be deleted. Also if
     * this node is the target of the only outgoing link of a
     * {@link OPMStructuralLinkAggregator}, the aggregator must be deleted.
     * 
     * @return a command that deletes a node and all other required diagram
     *         entities.
     */
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		OPMNode nodeToDelete =  (OPMNode) getHost().getModel();
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand = createRecursiveDeleteNodeCommand(nodeToDelete);
		
		return compoundCommand;

        
	}
	
	private CompoundCommand createRecursiveDeleteNodeCommand(OPMNode nodeToDelete) {
		CompoundCommand compoundCommand = new CompoundCommand();
		
		
		// For every outgoing structural link, create a command to delete the aggregator
        // node at the end of the link.
		for(OPMLink outgoingStructuralLink : nodeToDelete.getOutgoingStructuralLinks()) {
			OPMNode aggregatorNode = outgoingStructuralLink.getTarget();
			OPMNodeDeleteCommand aggregatorNodeDeleteCommand = new OPMNodeDeleteCommand();
			aggregatorNodeDeleteCommand.setNode(aggregatorNode);
			compoundCommand.add(aggregatorNodeDeleteCommand);			
		}
		// For every incoming structural link whose aggregator has only one outgoing
        // link, create a command to delete the aggregator.
		for(OPMLink incomingStructuralLink : nodeToDelete.getIncomingStructuralLinks()) {
			OPMNode aggregatorNode = incomingStructuralLink.getSource();
			if(aggregatorNode.getOutgoingLinks().size() == 1) {
				OPMNodeDeleteCommand aggregatorNodeDeleteCommand = new OPMNodeDeleteCommand();
				aggregatorNodeDeleteCommand.setNode(aggregatorNode);
				compoundCommand.add(aggregatorNodeDeleteCommand);
			}
		}
		
		for (OPMNode node : nodeToDelete.getNodes()) {
			Command containedNodeDelete = createRecursiveDeleteNodeCommand(node);
			compoundCommand.add(containedNodeDelete);
		}
		
		
		// Create a command to delete the node.
		OPMNodeDeleteCommand nodeDeleteCommand = new OPMNodeDeleteCommand();
		nodeDeleteCommand.setNode(nodeToDelete);
		compoundCommand.add(nodeDeleteCommand);

		return compoundCommand;
	}
	
	/**
    * Create a command to resize a node based on the current contents of the node.
    * The current implementation uses the figure's {@link OPMNodeFigure#getPreferredSize()} to
    * calculate this size.
    *
    * @return
    */
	private OPMNodeChangeConstraintCommand createResizeToContentsCommand() {
		OPMNodeEditPart host = (OPMNodeEditPart) getHost();
		OPMNode node = (OPMNode) host.getModel();
		OPMNodeFigure figure = (OPMNodeFigure) host.getFigure();
		
		// We assume the node's preferred size includes all of its contents.
		Dimension preferredSize = figure.getPreferredSize();
		preferredSize.expand(INSETS,INSETS);
		Rectangle newConstraints = node.getConstraints().getCopy();
		newConstraints.setWidth(preferredSize.width);
		newConstraints.setHeight(preferredSize.height);
		
		OPMNodeChangeConstraintCommand command = new OPMNodeChangeConstraintCommand();
		command.setNode(node);
		command.setNewConstraint(newConstraints);
		return command;
	}
	
	
	
	
	// for now we don't use ResizeToContentAction, I change this code to Comment.
	// if you want to use that action, uncommentrize this code.
	/* 
	
	
	/**
     * <p>Extends the parent implementation by handling incoming REQ_RESIZE_TO_CONTENTS requests.</p>
     * <p>The parent implementation {@inheritDoc}</p>
     
    @Override
    public Command getCommand(Request request) {
    	if(request.getType().equals(ResizeToContentsAction.REQ_RESIZE_TO_CONTENTS)) {
    		return createResizeToContentsCommand();
    	}
    	return super.getCommand(request);
    }
	
	*/
}

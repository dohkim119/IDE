package com.oscar.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OPMNode;


public class OPMNodeChangeConstraintCommand extends Command {
	private Rectangle oldConstraint;
	private Rectangle newConstraint;
	private OPMNode node;
	
	@Override
	public boolean canExecute() {
		return node != null && newConstraint != null;
	}
	
	@Override
	public boolean canUndo() {
		return node != null && oldConstraint != null;
	}
	
	@Override
	public void execute() {
		oldConstraint = node.getConstraints();
		node.setConstraints(newConstraint);
	}
	
	@Override
	public void undo() {
		node.setConstraints(oldConstraint);
	}
	
	public void setNode(final OPMNode node) {
		this.node = node;
	}
	
	public void setNewConstraint(final Rectangle newConstraint) {
		this.newConstraint = newConstraint;
	}
	
}

package com.oscar.opm.gef.editor.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OPMObjectProcessDiagram;
import com.oscar.opm.model.OPMContainer;
import com.oscar.opm.model.OPMNode;

public class OPMNodeCreateCommand extends Command {
		
	private OPMNode node;
	private Rectangle constraints;
	private OPMContainer container;
	
	@Override
	public boolean canExecute() {
	    return node != null && constraints != null && container != null;
	}
	
	@Override
	public void execute() {
		node.setConstraints(constraints);
		node.setContainer(container);
	}
	
	@Override
	public void undo() {
		node.setContainer(null);
	}
	
	
	public void setContainer(final OPMContainer container) {
		this.container = container;
	}
	
	public void setNode(final OPMNode node) {
		this.node = node;
	}
	
	public void setConstraints(final Rectangle constraints) {
	    this.constraints = constraints;
	}
	
	
}

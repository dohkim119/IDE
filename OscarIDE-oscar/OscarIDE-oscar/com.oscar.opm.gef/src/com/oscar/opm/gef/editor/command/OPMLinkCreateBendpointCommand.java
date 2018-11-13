package com.oscar.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;
import org.eclipse.draw2d.geometry.Point;

import com.oscar.opm.model.OPMLink;



public final class OPMLinkCreateBendpointCommand extends Command {
	
	private OPMLink link;
	private Point location;
	private int index;
	
	
	
	@Override
	public void execute() {
		link.getBendpoints().add(index,location);
	}
	
	@Override
	public void undo() {
		link.getBendpoints().remove(index);
	}
	
	public void setIndex(final int index) {
		this.index = index;
	}
	
	public void setLocation(final Point location) {
		this.location = location;
	}
	
	public void setOPMLink(final OPMLink link) {
		this.link = link;
	}
	
}

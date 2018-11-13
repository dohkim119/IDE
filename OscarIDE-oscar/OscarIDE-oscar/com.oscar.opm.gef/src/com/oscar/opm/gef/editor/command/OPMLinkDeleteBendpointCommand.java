package com.oscar.opm.gef.editor.command;


import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OPMLink;

public final class OPMLinkDeleteBendpointCommand extends Command {
	private Point location;
	
	private OPMLink link;
	
	private int index;
	
	
	@Override
	public boolean canExecute() {
		return (link!=null) && (link.getBendpoints().size() > index);
	}
	
	@Override
	public void execute() {
		location = link.getBendpoints().get(index);
		link.getBendpoints().remove(index);
	}
	
	@Override
	public void undo() {
		link.getBendpoints().add(index,location);
	}
	
	public void setOPMLink(final OPMLink link) {
		this.link = link;
	}
	
	public void setIndex(final int index) {
		this.index = index;
	}
	
	
	
}

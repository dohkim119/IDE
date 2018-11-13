package com.oscar.opm.gef.editor.command;

import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OPMLink;
import com.oscar.opm.model.OPMObjectProcessDiagram;
import com.oscar.opm.model.OPMNode;

public class OPMLinkDeleteCommand extends Command {

	private OPMNode source;
	private OPMNode target;
	private OPMLink link;
	private OPMObjectProcessDiagram opd;
	
	
	@Override
	public boolean canExecute() {
		return link!=null;
	}
	
	
	@Override
	public void execute() {
		/*
		source.getOutgoingLinks().remove(link);
		target.getIncomingLinks().remove(link);
		link.setOpd(null);
		*/
		opd = link.getOpd();
		source = link.getSource();
		target = link.getTarget();
		
		link.setSource(null);
		link.setTarget(null);
		link.setOpd(null);
	}
	
	@Override
	public void undo() {
		/*
		link.setOpd(opd);
		source.getOutgoingLinks().add(link);
		target.getIncomingLinks().add(link);
		*/
		link.setSource(source);
		link.setTarget(target);
		link.setOpd(opd);
	}
	
	public void setLink(final OPMLink linkParam) {
		link = linkParam;
	}
	
	
	
}

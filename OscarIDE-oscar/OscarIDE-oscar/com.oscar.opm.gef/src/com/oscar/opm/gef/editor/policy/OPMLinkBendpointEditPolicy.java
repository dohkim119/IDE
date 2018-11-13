package com.oscar.opm.gef.editor.policy;


import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.editpolicies.BendpointEditPolicy;

import com.oscar.opm.gef.editor.command.OPMLinkCreateBendpointCommand;
import com.oscar.opm.gef.editor.command.OPMLinkMoveBendpointCommand;
import com.oscar.opm.gef.editor.command.OPMLinkDeleteBendpointCommand;
import com.oscar.opm.model.OPMLink;



public class OPMLinkBendpointEditPolicy extends BendpointEditPolicy {
	
	@Override
	protected Command getCreateBendpointCommand(final BendpointRequest request) {
		OPMLinkCreateBendpointCommand command = new OPMLinkCreateBendpointCommand();
		
		Point p = request.getLocation();
		
		command.setOPMLink((OPMLink) request.getSource().getModel());
		command.setLocation(p);
		command.setIndex(request.getIndex());
		return command;
	}

	@Override
	protected Command getDeleteBendpointCommand(BendpointRequest request) {
		OPMLinkDeleteBendpointCommand command = new OPMLinkDeleteBendpointCommand();
		
		command.setOPMLink((OPMLink) request.getSource().getModel());
		command.setIndex(request.getIndex());
		return command;
	}

	@Override
	protected Command getMoveBendpointCommand(BendpointRequest request) {
		OPMLinkMoveBendpointCommand command = new OPMLinkMoveBendpointCommand();
		
		Point p = request.getLocation();
		
		command.setOPMLink((OPMLink) request.getSource().getModel());
		command.setLocation(p);
		command.setIndex(request.getIndex());
		
		return command;
	}

}

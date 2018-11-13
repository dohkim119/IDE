package com.oscar.opm.gef.editor.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import com.oscar.opm.gef.editor.command.OPMLinkDeleteCommand;
import com.oscar.opm.model.OPMLink;

public class OPMLinkConnectionEditPolicy extends ConnectionEditPolicy {

	@Override
	protected OPMLinkDeleteCommand getDeleteCommand(GroupRequest request) {
		OPMLinkDeleteCommand command = new OPMLinkDeleteCommand();
		command.setLink((OPMLink) getHost().getModel());
		return command;
	}

}

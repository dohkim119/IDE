package com.oscar.opm.gef.action;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

import com.oscar.opm.gef.editor.command.OscarCodeFileLocateCommand;
import com.oscar.opm.gef.editor.part.OscarCodeEditPart;
import com.oscar.opm.gef.utils.FileUtil;
import com.oscar.opm.model.OscarCode;

public class OscarCodePathChangeAction extends SelectionAction {
	
	public static final String CHANGE_CODEPATH = "ChangeCodePath";
	public static final String REQ_CHANGE_CODEPATH = "ChangeCodePath";
	
	Request request;
	
	/**
     * Create a new instance of the class.
     * @param part
     */
	public OscarCodePathChangeAction(IWorkbenchPart part) {
		super(part);
		setId(CHANGE_CODEPATH);
		setText("Change CodePath");
		request = new Request(REQ_CHANGE_CODEPATH);
	}
	
	
	public Request getRequest() {
		return request;
	}
	
	@Override
	public void run() {
		OscarCodeEditPart editpart = (OscarCodeEditPart) getSelectedObjects().get(0);
		OscarCodeFileLocateCommand command = new OscarCodeFileLocateCommand();	
		command.setModel(((OscarCode) editpart.getModel()));
		try{
			command.setFile(FileUtil.INSTANCE.openFile());
		} catch (Exception e) {return;}
		execute(command);
	}
	
	/**
     * {@inheritDoc}
     * <p>The action is enabled if selected entities is only one,
     *  and entity is {@link OscarCodeEditPart} instances</p>
     */
	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().size()!=1) {
			return false;
		}
		else if(getSelectedObjects().get(0) instanceof OscarCodeEditPart) return true;
		return false;
	}

}

package com.oscar.opm.gef.action;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IWorkbenchPart;

import com.oscar.opm.gef.editor.OPMGraphicalEditor;
import com.oscar.opm.gef.editor.command.OPMNodeCreateCommand;
import com.oscar.opm.gef.editor.factory.OPMObjectFactory;
import com.oscar.opm.model.OPMNode;

public class OPMCreateObjectAction extends WorkbenchPartAction {
	
	public static final String ID = "CreateObject";
	public static final String REQUEST = "CreateObject";
	
	private final CreateRequest request;
	private CreationTool tool;
	private static final Dimension DEFAULT_THING_DIMENSION = new Dimension(50,50);
	
	
	
	public OPMCreateObjectAction(IWorkbenchPart part) {
		super(part);
		request = new CreateRequest(REQUEST);
		setId(ID);
		setText("Create Object");
	}
	
	public Request getRequest() {
		return request;
	}
	
	@Override
	public void run() {
		// for now we don't use this, I change this code to comment.
		// if you want to use this code, change OPMGraphicalEditor's getEditDomain() method.
		// (it is also commentized)
		/*
		OPMGraphicalEditor editor = (OPMGraphicalEditor) getWorkbenchPart();
		CreationTool tool = new CreationTool(new OPMObjectFactory());
		editor.getEditDomain().setActiveTool(tool);
		*/
	}
	
	@Override
	protected boolean calculateEnabled() {
		return true;
	}

}

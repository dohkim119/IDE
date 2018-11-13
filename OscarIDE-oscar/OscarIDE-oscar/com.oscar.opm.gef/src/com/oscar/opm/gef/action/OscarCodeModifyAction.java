package com.oscar.opm.gef.action;

import java.io.File;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

import com.oscar.opm.gef.editor.part.OscarCodeEditPart;
import com.oscar.opm.model.OscarCode;

public class OscarCodeModifyAction extends SelectionAction {

	public static final String MODIFY_CODE = "ModifyCode";
	public static final String REQ_MODIFY_CODE = "ModifyCode";
	
	Request request;
	
	/**
     * Create a new instance of the class.
     * @param part
     */
	public OscarCodeModifyAction(IWorkbenchPart part) {
		super(part);
		setId(MODIFY_CODE);
		setText("Modify Code");
		request = new Request(REQ_MODIFY_CODE);
	}
	
	/**
     * Execute the commands that perform the {@link OscarCodeModifyAction#REQ_MODIFY_CODE REQ_MODIFY_CODE}.
     *
     * It is assumed that this method is executed directly after
     * {@link OscarCodeModifyAction#calculateEnabled() calculateEnabled()}
     */
	@Override
	public void run() {
	
		OscarCodeEditPart editpart = (OscarCodeEditPart) getSelectedObjects().get(0);
		File fileToOpen = ((OscarCode) editpart.getModel()).getCodefile();
		 
		if (fileToOpen.exists() && fileToOpen.isFile()) {
		    IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
		    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		 
		    try {
		        IDE.openEditorOnFileStore( page, fileStore );
		    } catch ( PartInitException e ) {
		        //Put your exception handler here if you wish to
		    }
		} else {
		    //Do something if the file does not exist
		}
		
		
		/*
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		
		OscarCodeEditPart editpart = (OscarCodeEditPart) getSelectedObjects().get(0);
		((OscarCode) editpart.getModel()).getCodefile();
		*/
		
		
		
		/*
		// selected objects must be nodes because the action is enabled.
		@SuppressWarnings("unchecked") List<OPMNodeEditPart> editParts = getSelectedObjects();
		CompoundCommand compoundCommand = new CompoundCommand();
		for(OPMNodeEditPart nodeEditPart : editParts) {
			if(!(nodeEditPart instanceof OPMStructuralLinkAggregatorEditPart)) {
				compoundCommand.add(nodeEditPart.getCommand(request));
			}
		}
		execute(compoundCommand);*/
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

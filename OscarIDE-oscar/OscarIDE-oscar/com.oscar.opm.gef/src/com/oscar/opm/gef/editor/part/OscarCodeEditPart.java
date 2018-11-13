package com.oscar.opm.gef.editor.part;

import java.io.File;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.Request;

import com.oscar.opm.gef.editor.figure.OscarCodeFigure;
import com.oscar.opm.gef.editor.tool.FileCreationTool;
import com.oscar.opm.gef.utils.FileUtil;
import com.oscar.opm.model.OscarCode;

public class OscarCodeEditPart extends OPMObjectEditPart {
	
	@Override 
	public void performRequest(Request req) {
		if(req.getType() == FileCreationTool.REQ_FILE_LOCATE) {
			performFileLocationSetting();
		}
		super.performRequest(req);
	}
	
	private void performFileLocationSetting()
	{
		// get FileLocation with GUI
		try {
			File selectedFile = FileUtil.INSTANCE.openFile();
			((OscarCode) getModel()).setCodefile(selectedFile);
		} catch(Exception e) {
			return;
		}
	}
	
	@Override
	protected IFigure createFigure() {
		return new OscarCodeFigure();
	}
}
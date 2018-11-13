package com.oscar.opm.gef.editor.part;

import org.eclipse.draw2d.IFigure;
import com.oscar.opm.gef.editor.figure.OPMProcessFigure;

public class OPMProcessEditPart extends OPMThingEditPart {

	@Override
	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return new OPMProcessFigure();
	}


}

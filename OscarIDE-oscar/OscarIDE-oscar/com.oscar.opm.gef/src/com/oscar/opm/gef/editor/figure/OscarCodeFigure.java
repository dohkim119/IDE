package com.oscar.opm.gef.editor.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;

public class OscarCodeFigure extends OPMObjectFigure {
	public OscarCodeFigure() {
		super();
		RectangleFigure rect = super.getRectangle();
		rect.setBorder(new LineBorder(ColorConstants.red,1));
		add(rect);
	}
	
}

package com.oscar.opm.gef.editor.figure;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

public class OPMProcessFigure extends OPMThingFigure {
	private Label nameLabel;
	private Ellipse ellipse;
	private ConnectionAnchor connectionAnchor;
	
	public OPMProcessFigure() {
		setLayoutManager(new XYLayout());
		nameLabel = new Label();
		add(nameLabel);
		ellipse = new Ellipse();
		ellipse.setFill(false);
		ellipse.setLayoutManager(new XYLayout());
		add(ellipse);
	}
	
	@Override
	public IFigure getContentPane() {
		return ellipse;
	}
	
	
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		setConstraint(ellipse,new Rectangle(0,0,r.width,r.height));
		setConstraint(nameLabel,new Rectangle(0,0,r.width,r.height));
		ellipse.invalidate();
		nameLabel.invalidate();
	}
	
	public Label getNameLabel() {
		return nameLabel;
	}
	
	private ConnectionAnchor getConnectionAnchor() {
		if (connectionAnchor == null) {
			connectionAnchor = new EllipseAnchor(this);
		}
		return connectionAnchor;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor() {
		return getConnectionAnchor();
	}
	
	public ConnectionAnchor getTargetConnectionAnchor() {
		return getConnectionAnchor();
	}
	
}

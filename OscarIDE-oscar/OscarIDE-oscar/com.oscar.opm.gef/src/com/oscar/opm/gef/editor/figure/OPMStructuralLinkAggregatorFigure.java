package com.oscar.opm.gef.editor.figure;


import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.oscar.opm.model.OPMStructuralLinkAggregatorKind;
import com.oscar.opm.model.OPMStructuralLinkAggregator;

/**
 * Draws the figure for a {@link OPMStructuralLinkAggregator}. This figure
 * consists of one or two {@link IsoscelesTriangle}, filled or not filled,
 * depending on the type of aggregator that is drawn (a parameter to the figure).  
 *
 */

public class OPMStructuralLinkAggregatorFigure extends Figure implements OPMNodeFigure {
	/** The triangle used as figure. */
	IsoscelesTriangle triangle;
	/** The inner Triangle used for an exhibition aggregator */
	IsoscelesTriangle innerTriangle;
	/** Anchor created at the center-top of the figure, used for target anchors. */
	private ConnectionAnchor topAnchor;
	/** Anchor created at the center-bottom of the figure, used for source anchors. */
	private ConnectionAnchor bottomAnchor;
	/** The kind of aggregator this figure represents. */
	OPMStructuralLinkAggregatorKind kind;
	
	public OPMStructuralLinkAggregatorFigure(OPMStructuralLinkAggregatorKind kind) {
		this.kind = kind;
		setLayoutManager(new XYLayout());
		triangle = new IsoscelesTriangle();
		triangle.setBackgroundColor(ColorConstants.black);
		switch(kind) {
		case AGGREGATION:
			triangle.setFill(true);
			break;
		case GENERALIZATION:
			triangle.setFill(false);
			break;
		case EXHIBITION:
			triangle.setFill(false);
			triangle.setLayoutManager(new XYLayout());
			innerTriangle = new IsoscelesTriangle();
			innerTriangle.setDirection(Orientable.NORTH);
			triangle.add(innerTriangle);
			break;
		default:
			throw new IllegalArgumentException("Invalid aggregator kind: " + kind);
		}
		add(triangle);
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getCopy();
		setConstraint(triangle,new Rectangle(0,0,bounds.width,bounds.height));
		if(kind == OPMStructuralLinkAggregatorKind.EXHIBITION) {
			triangle.setConstraint(innerTriangle, new Rectangle(bounds.width/3, bounds.height/2, bounds.width/3, bounds.height/3));
		}
		triangle.invalidate();
	}
	
	/**
     * Create a {@link ConnectionAnchor} that is located at the center-top of the figure.
     * @return a {@link ConnectionAnchor} at the center-top of the figure.
     */
	
	/*TODO - fix bugs with getTopAnchor() and getBottomAnchor().
	/ they have bugs with AbstractConnectionAnchor's getLocation method
	/ which should return relative coordinates to left-top corner's coordinate of viewer,
	/ but current implementation returns absolute coordinates from getOwner().getbounds()
	/ How to get left-top corner's coordinate of viewer in Figure object..? */
	private ConnectionAnchor getTopAnchor() {
		if(topAnchor == null) {
			IFigure parentFig = this.getParent();
			topAnchor = new AbstractConnectionAnchor(this) {
				@Override
				public Point getLocation(Point reference) {
					Point viewPortLocatePoint = new Point(0,0);
					IFigure parentFigure = parentFig;
					
					//get ViewPort's left-top coordinates to calculate real coordinate in viewport
					//viewPort is currentArea editor show to user.
					while( parentFigure != null ) 
					{
						if(parentFigure instanceof Viewport) 
						{
							Viewport viewport = (Viewport)parentFigure;
							viewPortLocatePoint = viewport.getViewLocation();
							parentFigure = null;
						}
						else parentFigure = parentFigure.getParent();
					}
					
					Point p = new Point();
					Rectangle ownerBounds = getOwner().getBounds().getCopy();
					p.x = ownerBounds.x + ownerBounds.width/2 - viewPortLocatePoint.x;
					p.y = ownerBounds.y - viewPortLocatePoint.y;
					return p;
				}
			};
		}
		return topAnchor;
	}
	/**
     * Create a {@link ConnectionAnchor} that is located at the center-bottom of the figure.
     * @return a {@link ConnectionAnchor} at the center-bottom of the figure.
     */
	private ConnectionAnchor getBottomAnchor() {
		if(bottomAnchor == null) {
			IFigure parentFig = this.getParent();
			bottomAnchor = new AbstractConnectionAnchor(this) {
				@Override
				public Point getLocation(Point reference) {
					Point viewPortLocatePoint = new Point(0,0);
					IFigure parentFigure = parentFig;
					
					//get ViewPort's left-top coordinates to calculate real coordinate in viewport
					//viewPort is currentArea editor show to user.
					while( parentFigure != null ) 
					{
						if(parentFigure instanceof Viewport) 
						{
							Viewport viewport = (Viewport)parentFigure;
							viewPortLocatePoint = viewport.getViewLocation();
							parentFigure = null;
						}
						else parentFigure = parentFigure.getParent();
					}
					
					Point p = new Point();
					Rectangle ownerBounds = getOwner().getBounds().getCopy();
					p.x = ownerBounds.x + ownerBounds.width/2 - viewPortLocatePoint.x;
					p.y = ownerBounds.y + ownerBounds.height - viewPortLocatePoint.y;
					return p;
				}
				
			};
		}
		return bottomAnchor;
	}
	
	@Override
	public ConnectionAnchor getSourceConnectionAnchor() {
		return getBottomAnchor();
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor() {
		return getTopAnchor();
	}
	

}

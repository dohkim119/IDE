package com.oscar.opm.gef.editor.part;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;

import com.oscar.opm.gef.editor.figure.CircleDecoration;
import com.oscar.opm.model.OPMProceduralLink;
import com.oscar.opm.model.OPMProceduralLinkKind;

public class OPMProceduralLinkEditPart extends OPMLinkEditPart {

	@Override
	protected PolylineConnection createFigure() {
		PolylineConnection connection = (PolylineConnection) super.createFigure();
		OPMProceduralLink model = (OPMProceduralLink) getModel();
		decorateConnection(connection,model.getKind());
		return connection;
	}
	
	
	private void decorateConnection(PolylineConnection connection, OPMProceduralLinkKind kind) {
		switch(kind) {
			case AGENT:
				CircleDecoration agentDecoration = new CircleDecoration();
				agentDecoration.setBackgroundColor(ColorConstants.black);
				agentDecoration.setFill(true);
				connection.setTargetDecoration(agentDecoration);
				break;
			case INSTRUMENT:
				CircleDecoration instrumentDecoration = new CircleDecoration();
				instrumentDecoration.setBackgroundColor(ColorConstants.white);
				instrumentDecoration.setFill(true);
				connection.setTargetDecoration(instrumentDecoration);
				break;
			case CONSUMPTION:
			case RESULT:
				connection.setTargetDecoration(new PolylineDecoration());
				break;
			case EFFECT:
				connection.setSourceDecoration(new PolylineDecoration());
				connection.setTargetDecoration(new PolylineDecoration());
				break;
			default:
				throw new IllegalArgumentException("No case for kind " + kind);
		}
	}
	
	
	
	
	
}

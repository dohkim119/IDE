package com.oscar.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OPMProceduralLink;
import com.oscar.opm.model.OPMProceduralLinkKind;

public class OPMAgentLinkFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPMProceduralLink link = OPMFactory.eINSTANCE.createOPMProceduralLink();
		link.setKind(OPMProceduralLinkKind.AGENT);
		return link;
	}

	@Override
	public Object getObjectType() {
		return OPMProceduralLink.class;
	}

}

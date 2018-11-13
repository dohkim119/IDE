package com.oscar.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OPMLink;

public class OPMLinkFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		return OPMFactory.eINSTANCE.createOPMLink();
	}

	@Override
	public Object getObjectType() {
		return OPMLink.class;
	}

}

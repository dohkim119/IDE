package com.oscar.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OscarCode;

public class OscarCodeFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		return OPMFactory.eINSTANCE.createOscarCode();
	}

	@Override
	public Object getObjectType() {
		return OscarCode.class;
	}

}

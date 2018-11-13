package com.oscar.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OPMProcess;

public class OPMProcessFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		return OPMFactory.eINSTANCE.createOPMProcess();
	}

	@Override
	public Object getObjectType() {
		return OPMProcess.class;
	}

}

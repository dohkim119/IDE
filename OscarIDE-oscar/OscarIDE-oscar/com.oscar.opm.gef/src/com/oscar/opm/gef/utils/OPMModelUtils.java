package com.oscar.opm.gef.utils;

import com.oscar.opm.model.OPMLink;
import com.oscar.opm.model.OPMObject;
import com.oscar.opm.model.OPMProcess;
import com.oscar.opm.model.OPMObjectProcessDiagram;
import com.oscar.opm.model.OPMFactory;

public enum OPMModelUtils {
	INSTANCE;
	
	private OPMFactory factory = OPMFactory.eINSTANCE;
	
	public OPMObjectProcessDiagram createModel() {
		OPMObjectProcessDiagram opd = factory.createOPMObjectProcessDiagram();
		OPMObject object1 = factory.createOPMObject();
		object1.setName("O1");
		opd.getNodes().add(object1);
		OPMObject object2 = factory.createOPMObject();
		object2.setName("O2");
		opd.getNodes().add(object2);
		OPMProcess process = factory.createOPMProcess();
		process.setName("P1");
		opd.getNodes().add(process);
		OPMLink link = factory.createOPMLink();
		link.setSource(object1);
		link.setTarget(process);
		opd.getLinks().add(link);
		return opd;
	}
}

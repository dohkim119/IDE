package com.oscar.opm.gef.editor.factory;

import org.eclipse.gef.requests.CreationFactory;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OPMStructuralLinkAggregator;
import com.oscar.opm.model.OPMStructuralLinkAggregatorKind;

public class OPMGeneralizationStructuralLinkAggregatorFactory implements CreationFactory {

	@Override
	public Object getNewObject() {
		OPMStructuralLinkAggregator aggregator = OPMFactory.eINSTANCE.createOPMStructuralLinkAggregator();
		aggregator.setKind(OPMStructuralLinkAggregatorKind.GENERALIZATION);
		return aggregator;
	}

	@Override
	public Object getObjectType() {
		return OPMStructuralLinkAggregator.class;
	}

}

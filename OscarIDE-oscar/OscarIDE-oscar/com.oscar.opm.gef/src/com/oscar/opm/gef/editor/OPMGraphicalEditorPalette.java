package com.oscar.opm.gef.editor;


import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;

import com.oscar.opm.gef.editor.factory.OPMAgentLinkFactory;
import com.oscar.opm.gef.editor.factory.OPMConsumptionLinkFactory;
import com.oscar.opm.gef.editor.factory.OPMEffectLinkFactory;
import com.oscar.opm.gef.editor.factory.OPMInstrumentLinkFactory;
import com.oscar.opm.gef.editor.factory.OPMLinkFactory;
import com.oscar.opm.gef.editor.factory.OPMObjectFactory;
import com.oscar.opm.gef.editor.factory.OPMProcessFactory;
import com.oscar.opm.gef.editor.factory.OPMResultLinkFactory;
import com.oscar.opm.gef.editor.factory.OscarCodeFactory;
import com.oscar.opm.gef.editor.factory.OPMAggregationStructuralLinkAggregatorFactory;
import com.oscar.opm.gef.editor.factory.OPMExhibitionStructuralLinkAggregatorFactory;
import com.oscar.opm.gef.editor.factory.OPMGeneralizationStructuralLinkAggregatorFactory;
import com.oscar.opm.gef.editor.tool.CreationAndDirectEditTool;
import com.oscar.opm.gef.editor.tool.FileCreationTool;

public class OPMGraphicalEditorPalette extends PaletteRoot {

	PaletteGroup group;
	
	public OPMGraphicalEditorPalette() {
		addGroup();
		addSelectionTool();
		addOPMObjectTool();
		addOPMProcessTool();
		addOPMLinkTool();
		addOPMProceduralLinkTools();
		addOPMStructuralLinkTools();
		addOscarCodeCreationTool();
	}
	
	private void addSelectionTool() {
		SelectionToolEntry entry = new SelectionToolEntry();
		group.add(entry);
		setDefaultEntry(entry);
	}
	
	private void addGroup() {
		group = new PaletteGroup("OPM Controls");
		add(group); 
	}
	
	private void addOPMObjectTool() {
		CreationToolEntry entry = new CreationToolEntry("OPMObject", "Create a new Object",new OPMObjectFactory(),null,null);
		entry.setToolClass(CreationAndDirectEditTool.class);
		group.add(entry);
	}
	
	private void addOPMProcessTool() {
		CreationToolEntry entry = new CreationToolEntry("OPMProcess","Create a new Process",new OPMProcessFactory(),null,null);
		entry.setToolClass(CreationAndDirectEditTool.class);
		group.add(entry);
	}
	
	private void addOPMLinkTool() {
		ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry("Link","Create a new link",new OPMLinkFactory(),null,null);
		group.add(entry);
	}
	
	private void addOPMProceduralLinkTools() {
		ConnectionCreationToolEntry entry;
		entry = new ConnectionCreationToolEntry("Agent","Create a new Agent Link",new OPMAgentLinkFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Instrument","Create a new Instrument Link",new OPMInstrumentLinkFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Consumption","Create a new Consumption Link",new OPMConsumptionLinkFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Result","Create a new Result Link",new OPMResultLinkFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Effect","Create a new Effect Link",new OPMEffectLinkFactory(),null,null);
		group.add(entry);
	}
	
	private void addOPMStructuralLinkTools() {
		ConnectionCreationToolEntry entry;
		entry = new ConnectionCreationToolEntry("Aggregation","Create a new Aggregation link",new OPMAggregationStructuralLinkAggregatorFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Exhibition","Create a new Exhibition link",new OPMExhibitionStructuralLinkAggregatorFactory(),null,null);
		group.add(entry);
		entry = new ConnectionCreationToolEntry("Generalization","Create a new Generalization link",new OPMGeneralizationStructuralLinkAggregatorFactory(),null,null);
		group.add(entry);
	}
	
	private void addOscarCodeCreationTool() {
		CreationToolEntry entry = new CreationToolEntry("OscarCode","Create a new Code",new OscarCodeFactory(),null,null);
		entry.setToolClass(FileCreationTool.class);
		group.add(entry);
	}
	
	
}

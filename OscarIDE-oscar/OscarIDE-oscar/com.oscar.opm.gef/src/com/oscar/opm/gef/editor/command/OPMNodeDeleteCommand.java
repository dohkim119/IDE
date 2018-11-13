package com.oscar.opm.gef.editor.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.Command;

import com.oscar.opm.model.OPMContainer;
import com.oscar.opm.model.OPMObjectProcessDiagram;
import com.oscar.opm.model.OPMNode;
import com.oscar.opm.model.OPMLink;

public class OPMNodeDeleteCommand extends Command {
	
	private OPMNode node;
	private OPMContainer container;
	private List<OPMLink> links;
	private Map<OPMLink,OPMNode> linkSources;
	private Map<OPMLink,OPMNode> linkTargets;
	
	@Override
	public void execute() {
		detachLinks();
		node.setContainer(null);
	}
	
	@Override
	public void undo() {
		reattachLinks();
		node.setContainer(container);
	}
	
	private void detachLinks() {
		links = new ArrayList<OPMLink>();
		linkSources = new HashMap<OPMLink,OPMNode>();
		linkTargets = new HashMap<OPMLink,OPMNode>();
		links.addAll(node.getIncomingLinks());
		links.addAll(node.getOutgoingLinks());
		for(OPMLink link : links) {
			linkSources.put(link, link.getSource());
			linkTargets.put(link, link.getTarget());
			link.setSource(null);
			link.setTarget(null);
			link.setOpd(null);
		}
	}
	
	private void reattachLinks() {
		for(OPMLink link : links) {
			link.setSource(linkSources.get(link));
			link.setTarget(linkTargets.get(link));
			if(container instanceof OPMObjectProcessDiagram) 
			{
				link.setOpd((OPMObjectProcessDiagram)container);
			}
			else 
			{
				OPMNode containerNode = (OPMNode) container;
				link.setOpd(containerNode.getOpd());
			}
		}
	}
	
	public void setNode(final OPMNode node) {
		this.node = node;
		this.container = node.getContainer();
	}
	
}

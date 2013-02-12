package edu.uib.gol.view.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.GUIWorldViewer;
import edu.uib.gol.view.WorldViewerPanel;

@Component
public class GUIWorldViewerFactory implements WorldViewerFactory{
	@Autowired WorldViewerPanelFactory panelFactory;
	public GUIWorldViewer createWorldViewer(Universe universe) {
		return new GUIWorldViewer(universe, panelFactory);
	}

}

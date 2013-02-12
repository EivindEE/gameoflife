package edu.uib.gol.view.factory;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.GUIWorldViewer;

@Component
public class GUIWorldViewerFactory implements WorldViewerFactory{

	public GUIWorldViewer createWorldViewer(Universe universe) {
		return new GUIWorldViewer(universe);
	}

}

package edu.uib.gol.view.factory;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.WorldViewerPanel;

@Component
public class WorldViewerPanelFactory {
	public WorldViewerPanel createWorldViewerPanel(Universe universe) {
		return new WorldViewerPanel(universe);
	}
}

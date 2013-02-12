package edu.uib.gol.view.factory;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.WorldViewer;

public interface WorldViewerFactory {
	public abstract WorldViewer createWorldViewer(Universe universe);
}

package edu.uib.gol.view;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;


@Component
public class PrintWorldViewerFactory {
	public PrintWorldViewer createWorldViewer(Universe universe) {
		Validate.notNull(universe, "The universe cannot be null");
		return new PrintWorldViewer(universe);
	} 
}

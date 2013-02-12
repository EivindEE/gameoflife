package edu.uib.gol.view.factory;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.PrintWorldViewer;


@Component
public class PrintWorldViewerFactory implements WorldViewerFactory{
	public PrintWorldViewer createWorldViewer(Universe universe) {
		Validate.notNull(universe, "The universe cannot be null");
		return createWorldViewer(universe, System.out);
	}
	
	public PrintWorldViewer createWorldViewer(Universe universe, PrintStream out) {
		return new PrintWorldViewer(universe, out);
	}
}

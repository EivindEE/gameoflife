package edu.uib.gol.view;

import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;


@Component
public class PrintWorldViewerFactory {
	public PrintWorldViewer createWorldViewer(Universe universe) {
		Validate.notNull(universe, "The universe cannot be null");
		return createWorldViewer(universe, System.out);
	}
	
	public PrintWorldViewer createWorldViewer(Universe universe, PrintStream out) {
		return new PrintWorldViewer(universe, out);
	}
}

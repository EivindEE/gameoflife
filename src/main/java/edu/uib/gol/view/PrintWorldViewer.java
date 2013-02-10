package edu.uib.gol.view;

import edu.uib.gol.model.Universe;


public class PrintWorldViewer implements WorldViewer{
	private Universe universe;
	public PrintWorldViewer(Universe universe) {
		this.universe = universe;
	}
	public void drawWorld() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < universe.getWorld().getWidth(); i++) {
			builder.append('|');
			for (int j = 0; j < universe.getWorld().getHeight(); j++) {
				builder.append(universe.getWorld().getCellAt(i, j).toString());
				builder.append('|');
			}
			builder.append('\n');
		}
		System.out.print(builder);
	}
}

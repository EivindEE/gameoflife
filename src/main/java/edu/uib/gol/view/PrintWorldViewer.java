package edu.uib.gol.view;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.World;


@Component
public class PrintWorldViewer implements WorldViewer{

	public void drawWorld(World world) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < world.getWidth(); i++) {
			builder.append('|');
			for (int j = 0; j < world.getHeight(); j++) {
				builder.append(world.getCellAt(i, j).toString());
				builder.append('|');
			}
			builder.append('\n');
		}
		System.out.println(builder);
	}
}

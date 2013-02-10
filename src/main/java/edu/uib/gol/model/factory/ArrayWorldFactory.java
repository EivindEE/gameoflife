package edu.uib.gol.model.factory;

import java.util.Random;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.Config;
import edu.uib.gol.model.ArrayWorld;
import edu.uib.gol.model.Cell;
import edu.uib.gol.model.ToroidalArrayWorld;
import edu.uib.gol.model.World;

@Component
public class ArrayWorldFactory implements WorldFactory {
	public World createWorld(int width, int height) {
		Validate.isTrue(width >= 0, "Width must be a non negative number");
		Validate.isTrue(height >= 0, "Height must be a non negative number");
		Cell[][] cells = new Cell[width][height];
		return createWorld(cells);
	}

	public World createWorld(Cell[][] cells) {
		return new ArrayWorld(cells);
	}

	public World createRandomWorld(int width, int height) {
		Cell[][] cells = new Cell[width][height];
		Random random = new Random();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = random.nextDouble() > Config.livingChance ? Cell.DEAD : Cell.LIVING; 
			}
		}
		return createWorld(cells);
	}
}

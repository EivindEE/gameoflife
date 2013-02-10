package edu.uib.gol.model.factory;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.ArrayWorld;
import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;

@Component
public class ArrayWorldFactory implements WorldFactory {
	public World createWorld(int width, int height) {
		Validate.isTrue(width >= 0, "Width must be a non negative number");
		Validate.isTrue(height >= 0, "Height must be a non negative number");
		return new ArrayWorld(width, height);
	}

	public World createWorld(Cell[][] cells) {
		return new ArrayWorld(cells);
	}

	public World createRandomWorld(int width, int height) {
		// TODO Auto-generated method stub
		return null;
	}

}

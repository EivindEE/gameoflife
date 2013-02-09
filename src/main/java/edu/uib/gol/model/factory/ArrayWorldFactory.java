package edu.uib.gol.model.factory;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.ArrayWorld;
import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;

@Component
public class ArrayWorldFactory implements WorldFactory {
	public World createWorld(int length, int height) {
		return new ArrayWorld(length, height);
	}

	public World buildWorld(Cell[][] cells) {
		return new ArrayWorld(cells);
	}

}

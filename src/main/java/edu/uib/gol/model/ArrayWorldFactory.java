package edu.uib.gol.model;

import org.springframework.stereotype.Component;

@Component
public class ArrayWorldFactory implements WorldFactory {
	public World buildWorld(int length, int height) {
		return new ArrayWorld(length, height);
	}

	public World buildWorld(Cell[][] cells) {
		return new ArrayWorld(cells);
	}

}

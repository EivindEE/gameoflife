package edu.uib.gol.model.factory;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;

public interface WorldFactory {

	public abstract World createWorld(int length, int height);

	public abstract World createWorld(Cell[][] cells);

}

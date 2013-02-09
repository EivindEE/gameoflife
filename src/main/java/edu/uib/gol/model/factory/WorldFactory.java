package edu.uib.gol.model.factory;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;

/**
 * Creates {@link World}s from the given parameters. 
 * Call in Slartibartfast.
 * @author eivindelseth
 *
 */
public interface WorldFactory {
	/**
	 * Creates a new {@link World} with the given width and height.
	 * @param width, the width of the world
	 * @param height, the height of the world
	 * @return a new {@link World} object
	 */
	public abstract World createWorld(int width, int height);

	/**
	 * Creates a new {@link World} from the given {@link Cell} array.
	 * @param cells, a two dimentional array of {@link Cell}s
	 * @return a new {@link World} object
	 */
	public abstract World createWorld(Cell[][] cells);

}

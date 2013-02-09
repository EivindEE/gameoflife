package edu.uib.gol.model.factory;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
/**
 * A factory that creates {@link Universe}es. Also called a God factory
 * @author eivindelseth
 *
 */
public interface UniverseFactory {
	/**
	 * Creates a new {@link Universe} object
	 * @param worldFactory, the factory used to create the following states
	 * @param world, the initial state of the universe
	 * @return the new {@link Universe}
	 */
	public Universe createUniverse(WorldFactory worldFactory, World world);

}

package edu.uib.gol.model.factory;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;

public interface UniverseFactory {

	public Universe createUniverse(WorldFactory worldFactory, World world);

}

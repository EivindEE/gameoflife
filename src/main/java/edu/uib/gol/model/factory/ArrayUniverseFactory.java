package edu.uib.gol.model.factory;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;

@Component
public class ArrayUniverseFactory implements UniverseFactory {

	public Universe createUniverse(WorldFactory worldFactory, World world) {
		return null;
	}
	
}

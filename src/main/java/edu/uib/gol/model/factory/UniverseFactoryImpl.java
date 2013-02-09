package edu.uib.gol.model.factory;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.UniverseImpl;
import edu.uib.gol.model.World;

@Component
public class UniverseFactoryImpl implements UniverseFactory {

	public Universe createUniverse(WorldFactory worldFactory, World world) {
		Validate.notNull(worldFactory, "WorldFactory cannot be null");
		Validate.notNull(world, "World cannot be null");
		return new UniverseImpl(worldFactory, world);
	}
	
}

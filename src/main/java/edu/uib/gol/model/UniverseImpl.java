package edu.uib.gol.model;

import edu.uib.gol.model.factory.WorldFactory;


public class UniverseImpl implements Universe {
	protected WorldFactory worldFactory;
	protected World world;
	
	public UniverseImpl(WorldFactory worldFactory, World initialWorld) {
		this.worldFactory = worldFactory;
		world = initialWorld;
	}
	
	public World getWorld() {
		return world;
	}

}

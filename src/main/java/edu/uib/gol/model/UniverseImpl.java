package edu.uib.gol.model;

import edu.uib.gol.model.factory.WorldFactory;


public class UniverseImpl implements Universe {
	protected WorldFactory worldFactory;
	protected World world;

	public UniverseImpl(WorldFactory worldFactory, World initialWorld) {
		this.worldFactory = worldFactory;
		this.world = initialWorld;
	}

	public World getWorld() {
		return world;
	}

	public World tick() {
		Cell[][] newState = new Cell[world.getWidth()][world.getHeight()];
		for( int i = 0; i < world.getWidth(); i++) {
			for( int j = 0; j < world.getHeight(); j++) {
				if(world.getCellAt(i, j) == Cell.DEAD) {
					if (world.numberOfAdjacentLivingCells(i, j) == 3) {
						newState[i][j] = Cell.LIVING;
					} else {
						newState[i][j] = Cell.DEAD;
					}
					
				} else {
					int adj = world.numberOfAdjacentLivingCells(i, j);
					if (adj < 2 || adj > 3) {
						newState[i][j] = Cell.DEAD;
					} else {
						newState[i][j] = Cell.LIVING;
					}
				}
			}	
		}
		world = worldFactory.createWorld(newState); 
		return world; 
	}

	public void setWorld(World world) {
		this.world = world;
	}
}

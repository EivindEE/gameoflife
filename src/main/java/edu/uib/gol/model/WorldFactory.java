package edu.uib.gol.model;

public interface WorldFactory {

	public abstract World buildWorld(int length, int height);

	public abstract World buildWorld(Cell[][] cells);

}

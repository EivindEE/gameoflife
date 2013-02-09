package edu.uib.gol.model;

/**
 * A snapshot of the World. A world consists of a collection of {@link Cell}s which can be accessed by their location on a 
 * two dimentional grid. A world knows where all its {@link Cell}s are, as well as how many {@link Cell}s are adjacent to each of them.  
 * @author eivindelseth
 *
 */
public interface World {
	/**
	 * Returns the {@link Cell} at the coordinate <x,y>
	 * @param x, the index along the width axis
	 * @param y, the index along the height axis
	 * @return the {@link Cell}
	 */
	public abstract Cell getCellAt(int x, int y);
	
	/**
	 * The width of the world
	 * @return the width
	 */
	public abstract int getWidth();
	/**
	 * The height of the world
	 * @return the height
	 */
	public abstract int getHeight();

	/**
	 * Sets the cell at <x,y> to the state of the {@link Cell} provided 
	 * @param x, the index along the width axis
	 * @param y, the index along the height axis
	 * @param cell, the state the cell at <x,y> should have
	 */
	public abstract void setCellAt(int x, int y, Cell cell);
	
	/**
	 * Returns the number of living adjacent cells for the cell at <x,y>
	 * @param x, the index along the width axis
	 * @param y, the index along the height axis
	 * @return the number of living adjacent cells
	 */
	public abstract int numberOfAdjacentLivingCells(int x, int y);
}
package edu.uib.gol.model;
/**
 * A Universe contains the world and keeps track of how it changes over time.
 * The universe follows the rules from <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules">Conways Game of Life</a>
 * @author eivindelseth
 *
 */
public interface Universe {
	
	/**
	 * The current state of the {@link World}
	 * @return the current {@link World}
	 */
	public abstract World getWorld();
	
	/**
	 * A tick represents the passing of one unit of time and changes the universes {@link World} to its next state, it also returns the new {@link World};
	 * The Rules used to create the next state are the following( from: <a href="http://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules">Conways Game of Life</a>)
	 * <li>Any live cell with fewer than two live neighbours dies, as if caused by under-population.</li>
	 * <li>Any live cell with two or three live neighbours lives on to the next generation.</li>
	 * <li>Any live cell with more than three live neighbours dies, as if by overcrowding.</li>
	 * <li>Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.</li>
	 * 
	 * @return the new {@link World}
	 */
	public abstract World tick();

}

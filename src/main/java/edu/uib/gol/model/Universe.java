package edu.uib.gol.model;
/**
 * A Universe contains the world and keeps track of how it changes over time 
 * @author eivindelseth
 *
 */
public interface Universe {
	
	/**
	 * The current state of the {@link World}
	 * @return the current {@link World}
	 */
	public abstract World getWorld();

}

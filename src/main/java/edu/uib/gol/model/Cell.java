package edu.uib.gol.model;
/**
 * A cell can be either living or dead.
 * This is the base unit in the game of life
 * @author eivindelseth
 *
 */
public enum Cell {
	LIVING("*"), DEAD(" ");
	private String state;
	private Cell(String living) {
		this.state = living;
	}
	
	@Override
	public String toString() {
		return this.state;
	}
}

package edu.uib.gol;

public enum Cell {
	LIVING("*"), DEAD(" ");
	private String state;
	private Cell(String living) {
		this.state = living;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.state;
	}
}

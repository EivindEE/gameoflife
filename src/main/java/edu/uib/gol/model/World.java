package edu.uib.gol.model;

public interface World {

	public abstract Cell getCellAt(int x, int y);

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract void setCellAt(int x, int y, Cell cell);

	public abstract int numberOfAdjacentLivingCells(int x, int y);

}
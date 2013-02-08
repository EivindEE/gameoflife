package edu.uib.gol;

import org.springframework.stereotype.Component;

/**
 * 
 * @author eivindelseth
 *
 */
@Component
public class ArrayWorld implements World {
	int width, height;
	Cell[][] cells;
	public ArrayWorld() {
		
	}
	public ArrayWorld(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Cell[width][height];
		for(int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = Cell.DEAD;
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.uib.gol.World#getCellAt(int, int)
	 */
	public Cell getCellAt(int x, int y) {
		return cells[x][y];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setCellAt(int x, int y, Cell cell) {
		this.cells[x][y] = cell;
	}
	
	public int numberOfAdjacentLivingCells(int x, int y) {
		int numberOfLivingCells = 0;
		int xStart, xEnd, yStart, yEnd;
		xStart = x == 0 ? 0 : -1;
		yStart = y == 0 ? 0 : -1;
		xEnd = x >= cells.length - 1? 0 : 1;
		yEnd = y >= cells[0].length - 1? 0 : 1;
		for (int i = xStart; i <= xEnd; i++) {
			for (int j = yStart; j <= yEnd; j++) {
				if (!(i == 0 && j == 0)) {
					numberOfLivingCells += this.getCellAt(x + i, y + j) == Cell.LIVING ? 1 : 0;
				}
			}
		}
		return numberOfLivingCells;
	}
}

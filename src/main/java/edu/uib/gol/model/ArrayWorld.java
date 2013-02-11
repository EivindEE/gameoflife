package edu.uib.gol.model;

import java.util.Arrays;

import org.apache.commons.lang.Validate;


/**
 * 
 * @author eivindelseth
 *
 */
public class ArrayWorld implements World{


	protected Cell[][] cells;
	
	public ArrayWorld(int width, int height) {
		this.cells = new Cell[width][height];
		for(int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = Cell.DEAD;
			}
		}
	}

	public ArrayWorld(Cell[][] cells) {
		this.cells = cells;
		for (int i = 0; i < this.cells.length; i++) {
			for (int j = 0; j < this.cells[i].length; j++) {
				this.cells[i][j] = this.cells[i][j] == null ? Cell.DEAD : this.cells[i][j];
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
		return cells.length;
	}
	
	public int getHeight() {
		return cells[0].length;
	}
	
	public int numberOfAdjacentLivingCells(int x, int y) {
		Validate.isTrue(x >= 0, "x must be >= 0");
		Validate.isTrue(x < this.getWidth(), "x must be less than width of world");
		Validate.isTrue(y>=0, "y must be >= 0");
		Validate.isTrue(y < this.getHeight(), "y must be less than heigt of world");
		int numberOfLivingCells = 0;
		int xPos, yPos;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0)) {
					xPos = x + i;
					yPos = y + j;
					if ( !(xPos >= cells.length || xPos < 0 || yPos >= cells[xPos].length || yPos < 0)) {
						numberOfLivingCells += this.getCellAt(xPos, yPos) == Cell.LIVING ? 1 : 0;
					}
				}
			}
		}
		return numberOfLivingCells;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayWorld other = (ArrayWorld) obj;
		return Arrays.deepEquals(cells, other.cells);
	}
}

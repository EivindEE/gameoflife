package edu.uib.gol.model;

import org.apache.commons.lang.Validate;

public class ToroidalArrayWorld extends ArrayWorld{

	public ToroidalArrayWorld(Cell[][] cells) {
		super(cells);
	}
	
	@Override
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
					if ( xPos >= cells.length) {
						xPos = 0;
					} else if (xPos < 0) {
						xPos = cells.length - 1;
					}
					if ( yPos >= cells[xPos].length) {
						yPos = 0;
					} else if (yPos < 0) {
						yPos = cells[xPos].length - 1;
					}
					numberOfLivingCells += this.getCellAt(xPos, yPos) == Cell.LIVING ? 1 : 0;
				}
			}
		}
		return numberOfLivingCells;
	}

}

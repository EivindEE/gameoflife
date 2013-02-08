package edu.uib.gol;

import org.springframework.stereotype.Component;

/**
 * 
 * @author eivindelseth
 *
 */
@Component
public class ArrayWorld implements World {
	int length, height;
	public ArrayWorld() {
		
	}
	public ArrayWorld(int length, int height) {
		this.length = length;
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see edu.uib.gol.World#getCellAt(int, int)
	 */
	public Cell getCellAt(int x, int y) {
		return Cell.DEAD;
	}
	
	public int getWidth() {
		return length;
	}
	public int getHeight() {
		return height;
	}
	public void setCellAt(int x, int y, Cell living) {
		// TODO Auto-generated method stub
		
	}
}

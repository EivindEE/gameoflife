package edu.uib.gol;

import org.springframework.stereotype.Component;

/**
 * 
 * @author eivindelseth
 *
 */
@Component
public class ArrayWorld implements World {
	/* (non-Javadoc)
	 * @see edu.uib.gol.World#getCellAt(int, int)
	 */
	public Cell getCellAt(int x, int y) {
		return Cell.DEAD;
	}
	

}

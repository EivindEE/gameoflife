package edu.uib.gol;

import static org.junit.Assert.*;
import edu.uib.gol.Cell;
import org.junit.Test;

public class CellTest {

	@Test
	public void testToString() {
		assertTrue("Dead cells should print a single space", Cell.DEAD.toString().equals(" "));
	}

}

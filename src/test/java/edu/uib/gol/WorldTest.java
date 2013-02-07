package edu.uib.gol;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.uib.gol.World;
public class WorldTest {
	World emptyWorld;
	@Before
	public void before() {
		emptyWorld = new World();
	}
	@Test
	public void testGetCellAt() {
		int x = 0,
			y = 0;
		assertEquals("The cell at 0,0 should be dead(Cell.DEAD) in an empty map", Cell.DEAD, emptyWorld.getCellAt(x,y));
	}

}

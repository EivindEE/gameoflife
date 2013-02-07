package edu.uib.gol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldTest {
	@Autowired
	World emptyWorld;
	
	@Test
	public void testGetCellAt() {
		int x = 0,
			y = 0;
		assertEquals("The cell at 0,0 should be dead(Cell.DEAD) in an empty map", Cell.DEAD, emptyWorld.getCellAt(x,y));
	}

}

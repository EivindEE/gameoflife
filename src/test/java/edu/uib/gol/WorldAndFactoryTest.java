package edu.uib.gol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldAndFactoryTest {
	@Autowired 
	WorldFactory worldFactory;
	
	World defaultWorld;
	int defaultLength = 3;
	int defaultHeight = 3;
	@Before
	public void setUp() {
		defaultWorld = worldFactory.buildWorld(defaultLength, defaultHeight);
	}
	
	@Test
	public void testBuildWorld() {
		World world = worldFactory.buildWorld(0,0);
		assertTrue("The builder should return a World object ", world instanceof World);
	}
	
	@Test
	public void testWorldSize() {
		assertEquals("The length of the universe should be the same as the length given",
				defaultLength, defaultWorld.getWidth());
		assertEquals("The height of the universe should be the same as the height given",
				defaultHeight, defaultWorld.getHeight());
		int newHeight = 10, 
			newLength = 11;
		World newWorld = worldFactory.buildWorld(newLength, newHeight);
		assertEquals("The length of the universe should be the same as the length given",
				newLength, newWorld.getWidth());
		assertEquals("The height of the universe should be the same as the height given",
				newHeight, newWorld.getHeight());
	}
	
	@Test
	public void testInitialState() {
		for( int i = 0; i < defaultLength; i++) {
			for (int j = 0; j < defaultHeight; j++) {
				assertEquals("Each cell in a default world should be dead", Cell.DEAD, defaultWorld.getCellAt(i, j));
			}
		}
	}
	
	@Test
	public void testGetAndSetCellAt() {
		
		int x = 0,
			y = 0;
		assertEquals("The cell at x,y should be dead(Cell.DEAD) in an empty map", Cell.DEAD, defaultWorld.getCellAt(x, y));
		defaultWorld.setCellAt(x, y, Cell.LIVING);
		assertEquals("The cell at x,y should be living when set", Cell.LIVING, defaultWorld.getCellAt(x, y));
		assertEquals("The cell at x,y + 1 should still be dead", Cell.DEAD, defaultWorld.getCellAt(x, y + 1));
		assertEquals("The cell at x + 1,y should still be dead", Cell.DEAD, defaultWorld.getCellAt(x + 1, y));
	}
}

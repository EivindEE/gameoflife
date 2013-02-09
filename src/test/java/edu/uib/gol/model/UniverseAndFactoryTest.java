package edu.uib.gol.model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;
import edu.uib.gol.view.WorldViewer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class UniverseAndFactoryTest {
	@Autowired
	UniverseFactory universeFactory;
	
	@Autowired
	WorldFactory worldFactory;
	@Autowired 
	WorldViewer viewer;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCreateUniverseNullFactory(){
		World world = worldFactory.createWorld(0,0);
		exception.expect(java.lang.IllegalArgumentException.class);
		universeFactory.createUniverse(null, world);
	}
	
	@Test
	public void testCreateUniverseNullWorld(){
		exception.expect(java.lang.IllegalArgumentException.class);
		universeFactory.createUniverse(worldFactory, null);
	}
	
	@Test
	public void testCreateUniverseAndGetWorld() {
		World world = worldFactory.createWorld(0,0);
		Universe universe = universeFactory.createUniverse(worldFactory, world);
		assertEquals("The universe should have the provided world as its initial world", world, universe.getWorld());
	}
	// Testing the rules 1 and 4 (http://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules)
	@Test
	public void testTickRule1And4() {
		Cell[][] initialState = new Cell[][] {
				{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING},
				{Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD},
				{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			};
		World initialWorld = worldFactory.createWorld(initialState);
		Universe universe = universeFactory.createUniverse(worldFactory, initialWorld);
		viewer.drawWorld(universe.getWorld());
		World tickedWorld = universe.tick();
		viewer.drawWorld(universe.getWorld());
		
		// Testing Rule 2: Any live cell with two or three live neighbours lives on to the next generation.
		assertEquals("The cell at 2,0 had 2 living neighbours and should stay alive", Cell.LIVING, tickedWorld.getCellAt(2, 0));
		assertEquals("The cell at 1,3 had 2 living neighbours and should stay alive", Cell.LIVING, tickedWorld.getCellAt(1, 3));
		
		// Testing Rule 3: Any live cell with more than three live neighbours dies, as if by overcrowding.
		assertEquals("The cell at 1,1 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(1, 1));
		assertEquals("The cell at 1,2 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(1, 2));
		assertEquals("The cell at 2,1 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 1));
		assertEquals("The cell at 2,2 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 2));
		
		// Testing Rule 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		assertEquals("The cell at 0,3 had exactly 3 neighbours and should become alive",Cell.LIVING, tickedWorld.getCellAt(0, 2));
		assertEquals("The cell at 0,0 had 1 neighbour and should stay dead",Cell.DEAD, tickedWorld.getCellAt(0, 0));
		assertEquals("The cell at 0,1 had 2 neighbours and should stay dead",Cell.DEAD, tickedWorld.getCellAt(0, 1));
		tickedWorld = universe.tick();
		viewer.drawWorld(universe.getWorld());

	}

}

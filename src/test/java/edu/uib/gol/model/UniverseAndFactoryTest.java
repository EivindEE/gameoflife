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
				{Cell.DEAD, Cell.DEAD, Cell.DEAD},
				{Cell.LIVING, Cell.LIVING, Cell.LIVING},
				{Cell.DEAD, Cell.DEAD, Cell.DEAD},
			};
		World initialWorld = worldFactory.createWorld(initialState);
		Universe universe = universeFactory.createUniverse(worldFactory, initialWorld);
		viewer.drawWorld(universe.getWorld());
		World tickedWorld = universe.tick();
		viewer.drawWorld(universe.getWorld());
		// Testing that the correct living cells have died
		assertEquals("The cell at 1,0 had fewer than two live neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(1, 0));
		assertEquals("The cell at 1,1 has two live neighbours and should be alive", Cell.LIVING, tickedWorld.getCellAt(1, 1));
		assertEquals("The cell at 1,2 had fewer than two live neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(1, 2));
		// Testing that the correct dead cells have come alive
		assertEquals("The cell at 0,0 did not have exactly 3 neighbours and should stay dead",Cell.DEAD, tickedWorld.getCellAt(0, 0));
		assertEquals("The cell at 0,1 had exactly 3 neighbours and should become alive",Cell.LIVING, tickedWorld.getCellAt(0, 1));
		
		tickedWorld = universe.tick();
		viewer.drawWorld(universe.getWorld());
		
		// Testing that the correct living cells have died
		assertEquals("The cell at 0,1 had fewer than two live neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(0, 1));
		assertEquals("The cell at 1,1 has two live neighbours and should be alive", Cell.LIVING, tickedWorld.getCellAt(1, 1));
		assertEquals("The cell at 2,1 had fewer than two live neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 1));
		// Testing that the correct dead cells have come alive
		assertEquals("The cell at 0,0 did not have exactly 3 neighbours and should stay dead",Cell.DEAD, tickedWorld.getCellAt(0, 0));
		assertEquals("The cell at 1,0 had exactly 3 neighbours and should become alive",Cell.LIVING, tickedWorld.getCellAt(1, 0));

	}

}

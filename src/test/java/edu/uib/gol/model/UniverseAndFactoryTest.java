package edu.uib.gol.model;

import static org.junit.Assert.*;

import org.junit.Before;
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
	
	// Two step oscillator http://upload.wikimedia.org/wikipedia/commons/1/12/Game_of_life_toad.gif
	// Step 1
	protected Cell[][] initial5x5 = new Cell[][] {
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD},
			{Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
	};
	// Step 2
	protected Cell[][] expected5x5 = new Cell[][] {
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD},
			{Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD},
			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
	};
	protected Universe universe;
	protected World expected5x5World;
	@Before 
	public void setUp() {
		World initialWorld = worldFactory.createWorld(initial5x5);
		universe = universeFactory.createUniverse(worldFactory, initialWorld);
		
		expected5x5World = worldFactory.createWorld(expected5x5);
	}

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

	@Test
	public void testTickRule1() {
		World tickedWorld = universe.tick();
		// After the first tick the cell at 1,0 should be alive
		// Testing Rule 1: Any live cell with fewer than two live neighbours dies, as if caused by under-population.
		tickedWorld = universe.tick();
		assertEquals("The Cell at 2,1 had 1 neighbour and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 1));
	}

	@Test
	public void testTickRule2() {
		World tickedWorld = universe.tick();
		// Testing Rule 2: Any live cell with two or three live neighbours lives on to the next generation.
		assertEquals("The cell at 3,1 had 2 living neighbours and should stay alive", Cell.LIVING, tickedWorld.getCellAt(3, 1));
		assertEquals("The cell at 2,4 had 2 living neighbours and should stay alive", Cell.LIVING, tickedWorld.getCellAt(2, 4));
	}

	public void testTickRule3() {
		World tickedWorld = universe.tick();

		// Testing Rule 3: Any live cell with more than three live neighbours dies, as if by overcrowding.
		assertEquals("The cell at 2,2 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 2));
		assertEquals("The cell at 2,3 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(2, 2));
		assertEquals("The cell at 3,2 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(3, 2));
		assertEquals("The cell at 3,3 had 4 living neighbours and should be dead", Cell.DEAD, tickedWorld.getCellAt(3, 3));
	}

	public void testTickRule4() {
		World tickedWorld = universe.tick();

		// Testing Rule 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		assertEquals("The cell at 1,3 had exactly 3 neighbours and should become alive",Cell.LIVING, tickedWorld.getCellAt(1, 3));
		assertEquals("The cell at 2,1 had exactly 3 neighbours and should become alive",Cell.LIVING, tickedWorld.getCellAt(2, 1));
		assertEquals("The cell at 1,1 had 1 neighbour and should stay dead",Cell.DEAD, tickedWorld.getCellAt(1, 1));
		assertEquals("The cell at 1,2 had 2 neighbours and should stay dead",Cell.DEAD, tickedWorld.getCellAt(1, 2));
	}

	public void testTickState() {
		World originalWorld = universe.getWorld();
		World tickedWorld = universe.tick();
		assertEquals("This is how the world should look after the first tick", expected5x5World, tickedWorld);
		assertNotSame("The original world should not have been changed", originalWorld, tickedWorld);
		tickedWorld = universe.tick();
		assertEquals("After second tick the two step oscillator should be back at initial state", originalWorld, tickedWorld);

	}

}

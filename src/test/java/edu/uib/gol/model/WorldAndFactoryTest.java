package edu.uib.gol.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.factory.WorldFactory;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldAndFactoryTest {
	@Autowired 
	WorldFactory worldFactory;

	World defaultWorld;
	int defaultWidth = 3;
	int defaultHeight = 3;
	int negativeNumber = -1;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		defaultWorld = worldFactory.createWorld(defaultWidth, defaultHeight);
	}


	@Test
	public void testCreateWorldNegativeWidth(){
		exception.expect(IllegalArgumentException.class);
		worldFactory.createWorld(negativeNumber, defaultHeight);
	}

	@Test
	public void testCreateWorldNegativeHeight(){
		exception.expect(IllegalArgumentException.class);
		worldFactory.createWorld(defaultWidth, negativeNumber);
	}

	@Test
	public void testDefaultCreateWorld() {
		World world = worldFactory.createWorld(defaultWidth, defaultHeight);
		assertEquals("The width of the created world should match the parameter", defaultWidth, world.getWidth());
		assertEquals("The height of the created world should match the parameter", defaultHeight, world.getHeight());
	}

	@Test
	public void testArrayCreateWorld() {
		Cell[][] cells = new Cell[][] 
				{
				{Cell.DEAD, Cell.LIVING},
				{Cell.LIVING, Cell.DEAD}
				};
		World fromArray = worldFactory.createWorld(cells);
		assertEquals("Cell at 0,0 should be dead", cells[0][0], fromArray.getCellAt(0, 0));
		assertEquals("Cell at 1,1 should be dead", cells[1][1], fromArray.getCellAt(1, 1));
		assertEquals("Cell at 0,1 should be living", cells[0][1], fromArray.getCellAt(0, 1));
		assertEquals("Cell at 1,0 should be living", cells[1][0], fromArray.getCellAt(1, 0));
	}

	@Test
	public void testArrayCreateWorldNullValues() {
		Cell[][] cells = new Cell[][] 
				{
				{null}
				};
		// Null values should be stored as Cell.DEAD
		World fromArray = worldFactory.createWorld(cells);
		assertNotNull("World object should not contain null values", fromArray.getCellAt(0, 0));
		assertEquals("null cells passed to WorldFactory should be converted to Cell.DEAD", Cell.DEAD, fromArray.getCellAt(0, 0));
	}


	@Test
	public void testWorldSize() {
		assertEquals("The length of the universe should be the same as the length given",
				defaultWidth, defaultWorld.getWidth());
		assertEquals("The height of the universe should be the same as the height given",
				defaultHeight, defaultWorld.getHeight());
		int newHeight = 10, 
				newLength = 11;
		World newWorld = worldFactory.createWorld(newLength, newHeight);
		assertEquals("The length of the universe should be the same as the length given",
				newLength, newWorld.getWidth());
		assertEquals("The height of the universe should be the same as the height given",
				newHeight, newWorld.getHeight());
	}

	@Test
	public void testInitialState() {
		for( int i = 0; i < defaultWorld.getWidth(); i++) {
			for (int j = 0; j < defaultWorld.getHeight(); j++) {
				assertEquals("Each cell in a default world should be dead", Cell.DEAD, defaultWorld.getCellAt(i, j));
			}
		}
	}

	@Test
	public void testGetCellAt() {
		int x = 0,
				y = 0;
		Cell[][] deadGrid = new Cell[][]{{Cell.DEAD}};
		Cell[][] livingGrid = new Cell[][]{{Cell.LIVING}};
		World deadWorld = worldFactory.createWorld(deadGrid);
		World livingWorld = worldFactory.createWorld(livingGrid);
		assertEquals("The cell at x,y should be dead", Cell.DEAD, deadWorld.getCellAt(x, y));
		assertEquals("The cell at x,y should be alive", Cell.LIVING, livingWorld.getCellAt(x, y));
	}

	@Test
	public void testGetCellAtHighHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.getCellAt(0, defaultHeight);
	}

	@Test
	public void testGetCellAtNegativeHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.getCellAt(0, -1);
	}


	@Test
	public void testGetCellAtHighWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.getCellAt(defaultWidth, 0);
	}

	@Test
	public void testGetCellAtNegativeWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.getCellAt(-1, 0);
	}

	@Test
	public void testNumberOfLivingAdjacentCells(){
		int x = 1, y = 1, numberOfLivingAdjacentCells = 0;
		Cell[][] cells = new Cell[][] {
				{Cell.DEAD, Cell.DEAD, Cell.DEAD},
				{Cell.DEAD, Cell.DEAD, Cell.DEAD},
				{Cell.DEAD, Cell.DEAD, Cell.DEAD}
		};
		World world = worldFactory.createWorld(cells);
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when all cells are dead", 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[0][0] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells, 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[0][1] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells,
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[0][2] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells,
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[1][0] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells,
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[1][2] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells, 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[2][0] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells,
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[2][1] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells, 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));
		cells[2][2] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells, 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));

		cells[1][1] = Cell.LIVING;
		world = worldFactory.createWorld(cells);
		assertEquals("The state of the cell should not affect the number of adjacent cells", 
				numberOfLivingAdjacentCells, world.numberOfAdjacentLivingCells(x,y));

		// Counting in corners should not throw out of bounds exceptions
		defaultWorld.numberOfAdjacentLivingCells(0, 0);
		defaultWorld.numberOfAdjacentLivingCells(defaultWidth - 1, defaultHeight - 1);

	}

	@Test
	public void testNumberOfLivingAdjacentCellsHighWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.numberOfAdjacentLivingCells(defaultWidth, 0);
	}

	@Test
	public void testNumberOfLivingAdjacentCellsNegativeWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.numberOfAdjacentLivingCells(-1, 0);
	}

	@Test
	public void testNumberOfLivingAdjacentCellsHighHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.numberOfAdjacentLivingCells(0, defaultHeight);
	}

	@Test
	public void testNumberOfLivingAdjacentCellsNegativeHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.numberOfAdjacentLivingCells(0, -1);
	}

	@Test
	public void testEquals() {
		Cell[][] cells = new Cell[][]{
				{Cell.LIVING, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING},
		};
		Cell[][] sameCells = new Cell[][]{
				{Cell.LIVING, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING},
		};
		Cell[][] differentCells = new Cell[][]{
				{Cell.DEAD, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING},
		};
		World world = worldFactory.createWorld(cells);
		World sameWorld = worldFactory.createWorld(sameCells);
		assertTrue("Two worlds with equal internal states should be equal", world.equals(sameWorld));
		World differentWorld = worldFactory.createWorld(differentCells);
		assertFalse("Two worlds with different internal states should be equal", world.equals(differentWorld));

	}
}

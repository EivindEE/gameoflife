package edu.uib.gol.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.WorldFactory;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldAndFactoryTest {
	@Autowired 
	WorldFactory worldFactory;
	
	World defaultWorld;
	int defaultWidth = 3;
	int defaultHeight = 3;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		defaultWorld = worldFactory.createWorld(defaultWidth, defaultHeight);
	}
	
	@Test
	public void testDefaultBuildWorld() {
		World world = worldFactory.createWorld(0,0);
		assertTrue("The builder should return a World object ", world instanceof World);
	}
	
	@Test
	public void testArrayBuildWorld() {
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
	public void testArrayBuildWorldNullValues() {
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
	public void testGetAndSetCellAt() {
		int x = 0,
			y = 0;
		assertEquals("The cell at x,y should be dead(Cell.DEAD) in an empty map", Cell.DEAD, defaultWorld.getCellAt(x, y));
		defaultWorld.setCellAt(x, y, Cell.LIVING);
		assertEquals("The cell at x,y should be living when set", Cell.LIVING, defaultWorld.getCellAt(x, y));
		assertEquals("The cell at x,y + 1 should still be dead", Cell.DEAD, defaultWorld.getCellAt(x, y + 1));
		assertEquals("The cell at x + 1,y should still be dead", Cell.DEAD, defaultWorld.getCellAt(x + 1, y));
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
	public void testSetCellAtHighHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.setCellAt(0, defaultHeight, null);
	}
	
	@Test
	public void testSetCellAtNegativeHeightIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.setCellAt(0, -1, null);
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
	public void testSetCellAtHighWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.setCellAt(defaultWidth, 0, null);
	}
	
	@Test
	public void testSetCellAtNegativeWidthIndex() {
		exception.expect(IndexOutOfBoundsException.class);
		defaultWorld.setCellAt(-1, 0, null);
	}
	
	@Test
	public void testNumberOfLivingAdjacentCells(){
		int x = 1, y = 1, numberOfLivingAdjacentCells = 0;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when all cells are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x + 1, y, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x - 1, y, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1 and x -1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x, y + 1, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1, x - 1, and y + 1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x, y - 1, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1, x - 1, y + 1 and y - 1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x - 1, y - 1, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1, x - 1, y + 1, y - 1, x-1 & y-1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x + 1, y + 1, Cell.LIVING);
		numberOfLivingAdjacentCells++;
		assertEquals("Number of living adjacent cells should be " + numberOfLivingAdjacentCells + " when cells at x + 1, x - 1, y + 1, y - 1, x - 1 & y - 1, and x + 1 & y + 1 is living and the rest are dead", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		defaultWorld.setCellAt(x, y, Cell.LIVING);
		assertEquals("The state of the cell should not affec the number of adjacent cells", numberOfLivingAdjacentCells, defaultWorld.numberOfAdjacentLivingCells(x,y));
		
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
}

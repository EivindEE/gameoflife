package edu.uib.gol.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class PrintWorldViewerAndFactoryTest {
	
	@Autowired
	PrintWorldViewerFactory viewFactory;
	
	@Autowired
	UniverseFactory universeFactory;
	
	@Autowired 
	@Qualifier("arrayWorldFactory")
	WorldFactory worldFactory;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	protected Universe universe;

	private ByteArrayOutputStream outContent;
	
	@Before
	public void setUp() {
		World world = worldFactory.createWorld(0, 0);
		universe = universeFactory.createUniverse(worldFactory, world);
		outContent = new ByteArrayOutputStream();
	}
	
	@Test
	public void testCreateWorldViewerNullArgument() {
		exception.expect(IllegalArgumentException.class);
		viewFactory.createWorldViewer(null);
	}
	
	@Test
	public void testCreateWorldViewer() {
		PrintWorldViewer worldViewer = viewFactory.createWorldViewer(universe);
		assertNotNull("The factory should not return a null object", worldViewer);
		assertTrue("Factory should return an object of type WorldViewer", worldViewer instanceof WorldViewer);
	}
	
	@Test
	public void testDrawWorldEmpty() {
		String expected = "";
		PrintStream actual = new PrintStream(outContent);
		PrintWorldViewer worldViewer = viewFactory.createWorldViewer(universe, actual);
		worldViewer.drawWorld();
		assertEquals("An empty world should give an empty string", expected, outContent.toString());
	}
	
	@Test
	public void testDrawWorld(){
		Cell[][] grid = new Cell[][] {
				{Cell.LIVING, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING}
		};
		World world = worldFactory.createWorld(grid);
		Universe universe = universeFactory.createUniverse(worldFactory, world);
		
		PrintStream actual = new PrintStream(outContent);
		PrintWorldViewer worldViewer = viewFactory.createWorldViewer(universe, actual);
		String expected = "|*| |\n| |*|\n";
		worldViewer.drawWorld();
		assertEquals(expected, outContent.toString());
	}

}

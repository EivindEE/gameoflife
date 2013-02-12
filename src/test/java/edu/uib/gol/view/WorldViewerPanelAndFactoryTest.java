package edu.uib.gol.view;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.CellRendererPane;

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
import edu.uib.gol.view.factory.GUIWorldViewerFactory;
import edu.uib.gol.view.factory.WorldViewerFactory;
import edu.uib.gol.view.factory.WorldViewerPanelFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldViewerPanelAndFactoryTest {
	@Autowired
	@Qualifier("worldViewerPanelFactory")
	WorldViewerPanelFactory panelFactory;
	
	@Autowired
	UniverseFactory universeFactory;
	
	@Autowired
	@Qualifier("arrayWorldFactory")
	WorldFactory worldFactory;
	
	protected Universe universe; 
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
			World world = worldFactory.createWorld(2, 2);
		universe = universeFactory.createUniverse(worldFactory, world);
	}
	
	@Test
	public void testCreateWorldViewer() {
		assertNotNull("The factory should not return null", panelFactory.createWorldViewerPanel(universe));
		exception.expect(IllegalArgumentException.class);
		panelFactory.createWorldViewerPanel(null);
	}
	
	@Test
	public void testDimensions() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WorldViewerPanel viewer = panelFactory.createWorldViewerPanel(universe);
		viewer.init();
		assertTrue("The panel is wider that the screen", viewer.getWidth() <= screenSize.width);
		assertTrue("The panel is heigher that the screen", viewer.getHeight() <= screenSize.height);
	}
	
	@Test
	public void testGetAndSetLivingColor(){
		WorldViewerPanel viewer = panelFactory.createWorldViewerPanel(universe);
		Color c1 = Color.BLACK;
		assertNotNull("The default color should not be null", viewer.getLivingColor());
		viewer.setLivingColor(c1);
		assertEquals(c1, viewer.getLivingColor());
	}
	
	@Test
	public void testGetAndSetDeadColor(){
		WorldViewerPanel viewer = panelFactory.createWorldViewerPanel(universe);
		Color c1 = Color.BLACK;
		assertNotNull("The default color should not be null", viewer.getDeadColor());
		viewer.setDeadColor(c1);
		assertEquals(c1, viewer.getDeadColor());
		Color c2 = Color.BLUE;
		viewer.setDeadColor(c2);
		assertEquals(c2, viewer.getDeadColor());
	}
	
	@Test
	public void testDrawWorld() {
		Cell[][] cells = new Cell[][]{
				{Cell.LIVING, Cell.DEAD},
				{Cell.DEAD, Cell.LIVING},
			};
		Integer numberOfLivingCells = 0;
		Integer numberOfDeadCells = 0;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j] == Cell.LIVING) {
					numberOfLivingCells++;
				} else {
					numberOfDeadCells++;
				}
			}
		}
		World world = worldFactory.createWorld(cells);
		universe.setWorld(world);
		WorldViewerPanel viewerPanel = panelFactory.createWorldViewerPanel(universe);
		GraphicsMock g = new GraphicsMock();
		viewerPanel.drawWorld(g);
		Color living = viewerPanel.getLivingColor();
		assertEquals("The number of drawn living cells should equal the number of living cells", numberOfLivingCells, g.getColorMap().get(living));
	}

}

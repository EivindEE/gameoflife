package edu.uib.gol.view;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;
import edu.uib.gol.view.factory.GUIWorldViewerFactory;
import edu.uib.gol.view.factory.WorldViewerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class GUIWorldViewerAndFactoryTest {
	@Autowired
	@Qualifier("GUIWorldViewerFactory")
	GUIWorldViewerFactory guiFactory;
	
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
		World world = worldFactory.createWorld(500, 500);
		universe = universeFactory.createUniverse(worldFactory, world);
	}
	
	@Test
	public void testCreateWorldViewer() {
		assertNotNull("The factory should not return null", guiFactory.createWorldViewer(universe));
		exception.expect(IllegalArgumentException.class);
		guiFactory.createWorldViewer(null);
	}
	
	@Test
	public void testDimensions() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		GUIWorldViewer viewer = guiFactory.createWorldViewer(universe);
		viewer.init();
		assertTrue("The panel is wider that the screen", viewer.getWidth() <= screenSize.width);
		assertTrue("The panel is heigher that the screen", viewer.getHeight() <= screenSize.height);
	}

}

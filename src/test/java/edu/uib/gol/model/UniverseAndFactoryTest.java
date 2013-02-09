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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class UniverseAndFactoryTest {
	@Autowired
	UniverseFactory universeFactory;
	
	@Autowired
	WorldFactory worldFactory;
	
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

}

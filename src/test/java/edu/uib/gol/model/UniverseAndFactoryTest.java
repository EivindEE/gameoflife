package edu.uib.gol.model;

import static org.junit.Assert.*;

import org.junit.Test;
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
	
	@Test
	public void testCreateUniverse() {
		World world = worldFactory.createWorld(0,0);
		universeFactory.createUniverse(worldFactory, world);
	}

}

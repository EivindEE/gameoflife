package edu.uib.gol;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.ToroidalArrayWorldFactory;
import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;
import edu.uib.gol.view.GUIWorldViewer;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
        WorldFactory worldFactory = context.getBean(ToroidalArrayWorldFactory.class);
        UniverseFactory universeFactory = context.getBean(UniverseFactory.class);
        Queue<World> worlds = new LinkedList<World>();
  
        World world = worldFactory.createRandomWorld(100, 100);
//        World world = worldFactory.createWorld(ManyWorlds.LWSS);
        Universe universe = universeFactory.createUniverse(worldFactory, world);
        GUIWorldViewer worldViewer = new GUIWorldViewer(universe);
		worldViewer.init();
        while(true) {
        	if (worlds.size() > 4) {
        		worlds.poll();
        	}
        	World current = universe.tick(); 
        	if (worlds.contains(current)) {
        		world = worldFactory.createRandomWorld(100, 100);
        		universe.setWorld(world);
        	}
        	worlds.add(current);
        	worldViewer.drawWorld();
        	Thread.sleep(100);
        	
        }
        
	}
}

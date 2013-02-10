package edu.uib.gol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;
import edu.uib.gol.view.GUIWorldViewer;
import edu.uib.gol.view.WorldViewer;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
        WorldFactory worldFactory = context.getBean(WorldFactory.class);
        UniverseFactory universeFactory = context.getBean(UniverseFactory.class);
        
  
        World world = worldFactory.createWorld(ManyWorlds.LWSS);
        Universe universe = universeFactory.createUniverse(worldFactory, world);
        GUIWorldViewer worldViewer = new GUIWorldViewer(universe);
		worldViewer.init();
        while(true) {
        	worldViewer.drawWorld();
        	Thread.sleep(500);
        	universe.tick();
        }
        
	}
}

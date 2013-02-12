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
import edu.uib.gol.view.WorldViewerPanel;
import edu.uib.gol.view.factory.GUIWorldViewerFactory;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
        WorldFactory worldFactory = context.getBean(ToroidalArrayWorldFactory.class);
        UniverseFactory universeFactory = context.getBean(UniverseFactory.class);
        GUIWorldViewerFactory viewerFactory = context.getBean(GUIWorldViewerFactory.class);
        Queue<World> worlds = new LinkedList<World>();
        int worldSize = 300;
        World world = worldFactory.createRandomWorld(worldSize, worldSize);
//        World world = worldFactory.createWorld(ManyWorlds.LWSS);
        Universe universe = universeFactory.createUniverse(worldFactory, world);
        GUIWorldViewer worldViewer = viewerFactory.createWorldViewer(universe);
        while(true) {
        	if (worlds.size() > 4) {
        		worlds.poll();
        	}
        	World current = universe.tick(); 
        	if (worlds.contains(current)) {
        		world = worldFactory.createRandomWorld(worldSize, worldSize);
        		universe.setWorld(world);
        	}
        	worlds.add(current);
        	worldViewer.drawWorld();
        	Thread.sleep(100);
        }
	}
}

package edu.uib.gol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;
import edu.uib.gol.model.factory.UniverseFactory;
import edu.uib.gol.model.factory.WorldFactory;
import edu.uib.gol.view.WorldViewer;

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
        WorldFactory worldFactory = context.getBean(WorldFactory.class);
        UniverseFactory universeFactory = context.getBean(UniverseFactory.class);
        WorldViewer worldViewer = context.getBean(WorldViewer.class);
        Cell[][] cells = new Cell[][] {
    			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
    			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
    			{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD},
    			{Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD, Cell.DEAD},
    			{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD},
    			{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD}
    	};
        World world = worldFactory.createWorld(cells);
        Universe universe = universeFactory.createUniverse(worldFactory, world);
        for (int i = 0; i < 100; i++) {
        	worldViewer.drawWorld();
        	Thread.sleep(1000);
		}
	}

}

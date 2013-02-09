package edu.uib.gol.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.World;
import edu.uib.gol.model.WorldFactory;


@Component
public class PrintWorldViewer implements WorldViewer{

	public void drawWorld(World world) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < world.getWidth(); i++) {
			builder.append('|');
			for (int j = 0; j < world.getHeight(); j++) {
				builder.append(world.getCellAt(i, j).toString());
				builder.append('|');
			}
			builder.append('\n');
		}
		System.out.println(builder);
	}
	
	
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
        WorldFactory worldFactory = context.getBean(WorldFactory.class);
        WorldViewer worldViewer = context.getBean(WorldViewer.class);
        Cell[][] cells = new Cell[][]{
        			{Cell.LIVING},
        			{Cell.DEAD}
        		};
       
       worldViewer.drawWorld( worldFactory.buildWorld(cells));
	}

}

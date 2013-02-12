package edu.uib.gol.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.commons.lang.Validate;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;

public class GUIWorldViewer extends JFrame implements WorldViewer  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Universe universe;

	private int cellXY;
//	private JPanel[][] grid;

	public GUIWorldViewer (Universe universe) {
		Validate.notNull(universe, "Universe cannot be null");
		this.universe = universe;
		World w = this.universe.getWorld();
		int width = w.getWidth();
		int height = w.getHeight();
		//		this.grid = new JPanel[width][height];
		this.setLayout(new GridLayout(width, height));
		this.setResizable(false);
	}

	public void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cellXY = Math.min((screenSize.width / universe.getWorld().getWidth()), (screenSize.height / universe.getWorld().getHeight()));
		Dimension cellDimension = new Dimension(cellXY,cellXY);
		this.setSize(new Dimension(cellXY * universe.getWorld().getHeight(), cellXY * universe.getWorld().getWidth()));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void drawWorld() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		World world = universe.getWorld();
		int width = world.getWidth();
		int height = world.getHeight();
		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color color = world.getCellAt(i, j) == Cell.LIVING ? Color.DARK_GRAY:  Color.CYAN;
				drawCell(color, i, j, g);
			}
		}
	}

	private void drawCell(Color color, int x, int y, Graphics2D g) {
		if (g == null) {
			g = (Graphics2D) getGraphics();
		}
		if (g != null) {
			g.setPaint(color);
			g.fillRect(x * cellXY, y * cellXY, cellXY, cellXY);
		}
	}
	
	
}

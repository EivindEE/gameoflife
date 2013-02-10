package edu.uib.gol.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;

public class GUIWorldViewer extends JFrame implements WorldViewer  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Universe universe;
	private JPanel[][] grid;
	private int cellXY = 50;
	private Dimension cellDimension = new Dimension(cellXY,cellXY);
	
	public GUIWorldViewer (Universe universe) {
		this.universe = universe;
		World w = this.universe.getWorld();
		int width = w.getWidth();
		int height = w.getHeight();
		this.grid = new JPanel[width][height];
		this.setLayout(new GridLayout(width, height));
		this.setResizable(false);
	}
	
	public void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		while (cellDimension.getWidth() * grid.length > screenSize.getWidth()
				||
				cellDimension.getHeight() * grid[0].length > screenSize.getHeight()){
			cellXY--;
			cellDimension = new Dimension(cellXY, cellXY);
		}
		this.setSize(new Dimension((int) cellDimension.getHeight() * grid[0].length, (int) cellDimension.getWidth() * grid.length));
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new JPanel(new BorderLayout());
				grid[i][j].setSize(cellDimension);
				grid[i][j].setBackground(universe.getWorld().getCellAt(i, j) == Cell.LIVING ? Color.GREEN:  Color.BLACK);
				this.add(grid[i][j]);
			}
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void drawWorld() {
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j].setBackground(universe.getWorld().getCellAt(i, j) == Cell.LIVING ? Color.GREEN:  Color.BLACK);
			}
		}
	}

}

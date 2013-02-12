package edu.uib.gol.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import org.apache.commons.lang.Validate;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.Universe;
import edu.uib.gol.model.World;

public class WorldViewerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Universe universe;

	private int cellXY;

	public WorldViewerPanel (Universe universe) {
		Validate.notNull(universe, "Universe cannot be null");
		this.universe = universe;
	}

	public void init() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cellXY = Math.min((screenSize.width / universe.getWorld().getWidth()), (screenSize.height / universe.getWorld().getHeight()));
		this.setSize(new Dimension(cellXY * universe.getWorld().getHeight(), cellXY * universe.getWorld().getWidth()));
		this.setVisible(true);
	}

	public void drawWorld(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		World world = universe.getWorld();
		int width = world.getWidth();
		int height = world.getHeight();
		for(int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Color color = world.getCellAt(i, j) == Cell.LIVING ? Color.DARK_GRAY:  Color.CYAN;
				drawCell(color, i, j, g2);
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
	
	@Override
	protected void paintComponent(Graphics g) {
		this.drawWorld(g);
	}
	
	
}

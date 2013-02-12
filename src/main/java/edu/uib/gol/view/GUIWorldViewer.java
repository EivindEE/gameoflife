package edu.uib.gol.view;

import java.awt.Graphics;

import javax.swing.JFrame;

import edu.uib.gol.model.Universe;
import edu.uib.gol.view.factory.WorldViewerPanelFactory;

public class GUIWorldViewer extends JFrame implements WorldViewer{
	
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	WorldViewerPanel viewerPanel;
	public GUIWorldViewer(Universe universe, WorldViewerPanelFactory panelFactory) {
		viewerPanel = panelFactory.createWorldViewerPanel(universe);
		viewerPanel.init();
		this.setSize(viewerPanel.getSize());
		this.add(viewerPanel);
		this.setVisible(true);
		this.setName("Game of life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.createBufferStrategy(4);
	}
	
	public void drawWorld() {
		Graphics g = getBufferStrategy().getDrawGraphics();
		viewerPanel.update(g);
		g.dispose();
		getBufferStrategy().show();
	}
	
}

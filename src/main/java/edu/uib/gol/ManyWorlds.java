package edu.uib.gol;

import edu.uib.gol.model.Cell;

public class ManyWorlds {
	public final static Cell[][] GLIDER = new Cell[][] {
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD}
	};
	
	
	
	public final static Cell[][] LWSS = new Cell[][] {
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.LIVING, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
		{Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD, Cell.DEAD},
	};
}

package edu.uib.gol.model.factory;

import org.springframework.stereotype.Component;

import edu.uib.gol.model.Cell;
import edu.uib.gol.model.ToroidalArrayWorld;
import edu.uib.gol.model.World;

@Component
public class ToroidalArrayWorldFactory extends ArrayWorldFactory {
	@Override
	public World createWorld(Cell[][] cells) {
		return new ToroidalArrayWorld(cells);
	}
}

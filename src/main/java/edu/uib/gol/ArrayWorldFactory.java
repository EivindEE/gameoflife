package edu.uib.gol;

import org.springframework.stereotype.Component;

@Component
public class ArrayWorldFactory implements WorldFactory {
	public World buildWorld(int length, int height) {
		return new ArrayWorld(length, height);
	}

}

package edu.uib.gol.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.uib.gol.model.factory.WorldFactory;

@Component
public class WorldReaderImpl implements WorldReader{
	@Autowired
	@Qualifier("arrayWorldFactory")
	WorldFactory worldFactory;
	 public static char LIVING = '*';
	 public static char DEAD = ' ';
	
	public World read(InputStream inputStream) throws IOException {
		Validate.notNull(inputStream, "Cannot read a null InputStream");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		List<String> lines = new LinkedList<String>();
		while(reader.ready()){
			lines.add(reader.readLine());
		}
		Cell[][] cells = new Cell[lines.size()][];
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			Cell[] column = new Cell[line.length()];
			for (int j = 0; j < line.length(); j++) {
				column[j] = line.charAt(j) == LIVING ? Cell.LIVING : Cell.DEAD;
			}
			cells[i] = column;
			
		}
		
		return worldFactory.createWorld(cells);
	}

	public World read(File worldFile) throws IOException {
		Validate.notNull(worldFile, "Cannot read a null file");
		InputStream stream = new FileInputStream(worldFile);
		return this.read(stream);
	}

}

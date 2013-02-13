package edu.uib.gol.model;

import java.io.IOException;
import java.io.OutputStream;

public interface WorldWriter {

	public void write(World world, OutputStream outputStream) throws IOException;

}

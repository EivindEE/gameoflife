package edu.uib.gol.model;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public interface WorldWriter {

	public void write(World world, OutputStream outputStream) throws IOException;

	public void write(World world4x4, File worldFile) throws IOException;

}

package edu.uib.gol.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface WorldReader {

	public abstract World read(InputStream inputStream) throws IOException;

	public abstract World read(File worldFile) throws IOException;

}

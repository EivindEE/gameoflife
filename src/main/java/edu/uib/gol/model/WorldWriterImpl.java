package edu.uib.gol.model;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;
@Component
public class WorldWriterImpl implements WorldWriter {
	private static String DEAD_CELL = " ";
	private static String LIVING_CELL = "*";
	private static String LINE_SEPARATOR = "\n";
	private StringBuilder stringBuilder;
	
	public void write(World world, OutputStream outputStream) throws IOException {
		Validate.notNull(world, "Cannot provide a null world");
		Validate.notNull(outputStream, "Cannot provide a null stream");
		stringBuilder = new StringBuilder("");
		for (int i = 0; i < world.getWidth(); i++) {
			for (int j = 0; j < world.getHeight(); j++) {
				stringBuilder.append(world.getCellAt(i, j) == Cell.LIVING ? LIVING_CELL : DEAD_CELL);
			}
			if( (i + 1) != world.getWidth()) {
				stringBuilder.append(LINE_SEPARATOR);
			}
		}
		outputStream.write(stringBuilder.toString().getBytes(Charset.forName("UTF-8")));
	}
}

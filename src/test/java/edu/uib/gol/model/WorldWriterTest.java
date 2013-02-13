package edu.uib.gol.model;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.factory.WorldFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldWriterTest {
	@Autowired
	WorldWriter writer;

	@Autowired
	@Qualifier("arrayWorldFactory")
	WorldFactory worldFactory;

	@Rule
	public ExpectedException exception = ExpectedException.none();
	private  static String DEAD_CELL = " ";
	private  static String LIVING_CELL = "*";
	private  static String LINE_SEPARATOR = "\n";
	private ByteArrayOutputStream outputStream;
	
	@Before
	public void setUp() {
		outputStream = new ByteArrayOutputStream();
	}
	@Test
	public void testWrite() throws IOException {
		Cell[][] cells = new Cell[][] {
				{Cell.DEAD, Cell.LIVING},
				{Cell.LIVING, Cell.DEAD},
		};
		StringBuilder expected = new StringBuilder("");
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				expected.append(cells[i][j] == Cell.LIVING ? LIVING_CELL : DEAD_CELL);
			}
			if (i + 1 != cells.length) {
				expected.append(LINE_SEPARATOR);
			}
		}
		World world = worldFactory.createWorld(cells);
		writer.write(world, outputStream);
		assertEquals("The output should match the given format", expected.toString(), outputStream.toString());
	}
	
	@Test
	public void testWriteNullWorld() throws IOException {
		exception.expect(IllegalArgumentException.class);
		writer.write(null, outputStream);
	}
	
	@Test
	public void testWriteNullStream() throws IOException {
		exception.expect(IllegalArgumentException.class);
		World world = worldFactory.createRandomWorld(0, 0);
		writer.write(world, null);
	}
	
	@Test
	public void testWriteInvalidStream() throws IOException {
		exception.expect(IOException.class);
		File file = new File("");
		OutputStream closedStream = new FileOutputStream(file); 
		closedStream.close();
		World world = worldFactory.createRandomWorld(0, 0);
		writer.write(world, closedStream);		
	}

}

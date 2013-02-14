package edu.uib.gol.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.uib.gol.model.factory.WorldFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class WorldWriterAndReaderTest {
	@Autowired
	WorldWriter writer;
	@Autowired
	public  WorldReader reader;

	@Autowired
	@Qualifier("arrayWorldFactory")
	WorldFactory worldFactory;

	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	private File worldFile;
	private  static String DEAD_CELL = " ";
	private  static String LIVING_CELL = "*";
	private  static String LINE_SEPARATOR = "\n";
	private ByteArrayOutputStream outputStream;
	private Cell[][] cells4x4 = new Cell[][] {
			{Cell.DEAD, Cell.LIVING},
			{Cell.LIVING, Cell.DEAD},
	};
	String world4x4String;
	private World world4x4; 
	@Before
	public void setUp() throws IOException {
		outputStream = new ByteArrayOutputStream();
		world4x4 = worldFactory.createWorld(cells4x4);
		StringBuilder expected = new StringBuilder("");
		for (int i = 0; i < world4x4.getWidth(); i++) {
			for (int j = 0; j < world4x4.getHeight(); j++) {
				expected.append(cells4x4[i][j] == Cell.LIVING ? LIVING_CELL : DEAD_CELL);
			}
			if (i + 1 != cells4x4.length) {
				expected.append(LINE_SEPARATOR);
			}
		}
		world4x4String = expected.toString();
		worldFile = folder.newFile("worldFile");
		
	}
	@Test
	public void testWrite() throws IOException {


		writer.write(world4x4, outputStream);
		assertEquals("The output should match the given format", world4x4String, outputStream.toString());
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
		OutputStream nullStream = null;
		writer.write(world, nullStream);
	}
	
	@Test
	public void testWriteInvalidStream() throws IOException {
		exception.expect(IOException.class);
		OutputStream closedStream = new FileOutputStream(worldFile); 
		closedStream.close();
		writer.write(world4x4, closedStream);		
	}
	
	@Test
	public void testRead() throws IOException {
		InputStream inputStream = new ByteArrayInputStream(world4x4String.getBytes());
		World actual = reader.read(inputStream);
		assertNotNull("Should not return a null world", actual);
		assertEquals("The two worlds should be equal", world4x4, actual);	
	}
	
	@Test
	public void testReadNullStream() throws IOException {
		exception.expect(IllegalArgumentException.class);
		InputStream nullStream = null;
		reader.read(nullStream);	
	}
	
	@Test
	public void testReadAndWriteEquals() throws IOException {
		writer.write(world4x4, outputStream);
		String worldString = outputStream.toString();
		InputStream inputStream = new ByteArrayInputStream(worldString.getBytes());
		World readWorld = reader.read(inputStream);
		assertTrue("The written and read would should equal the original world", readWorld.equals(world4x4));
	}
	
	@Test
	public void testWriteAndReadFile() throws IOException {
		writer.write(world4x4, worldFile);
		World readWorld = reader.read(worldFile);
		assertNotNull("Read world should not be null", readWorld);
		assertTrue("The written and read world should equal the original world", readWorld.equals(world4x4));
	}
	
	@Test
	public void testWriteNullFile() throws IOException {
		File nullFile = null;
		exception.expect(IllegalArgumentException.class);
		writer.write(world4x4, nullFile);
	}
	
	@Test
	public void testWriteFileNullWorld() throws IOException {
		exception.expect(IllegalArgumentException.class);
		writer.write(null, worldFile);
	}
	
	@Test
	public void testReadNullFile() throws IOException {
		exception.expect(IllegalArgumentException.class);
		File nullFile = null;
		reader.read(nullFile);
	}
}

package edu.uib.gol;

import static org.junit.Assert.*;
import edu.uib.gol.Cell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class CellTest {

	@Test
	public void testToString() {
		assertTrue("Dead cells should print a single space", Cell.DEAD.toString().equals(" "));
		assertTrue("Living cells should print a single astrix", Cell.LIVING.toString().equals("*"));
	}

}

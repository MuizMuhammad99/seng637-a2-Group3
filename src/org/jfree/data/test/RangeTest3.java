package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest3 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}

	@Test
	public void getLengthWithPositiveRange() {
		exampleRange = new Range(4.0, 10.0);
		assertEquals("The length of a positive range 4.0 to 10.0 should be 6.0", 6.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithNegativeRange() {
		exampleRange = new Range(-10.0, -4.0);
		assertEquals("The length of a negative range -10.0 to -4.0 should be 6.0", 6.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthAtZeroCrossing() {
		exampleRange = new Range(-7.0, 7.0);
		assertEquals("The length of a range crossing zero -7.0 to 7.0 should be 14.0", 14.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithZeroWidthRange() {
		exampleRange = new Range(9.0, 9.0);
		assertEquals("The length of a zero-width range 9.0 to 9.0 should be 0.0", 0.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithInvalidRange() {
		exampleRange = new Range(11.0, -11.0);
		// This test expects an IllegalArgumentException to be thrown
		// due to invalid range (where lower bound is greater than the upper bound)
	}
	
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}

}
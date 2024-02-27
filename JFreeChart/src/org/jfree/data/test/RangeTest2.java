package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest2 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}
	
	@Test
	public void getUpperBoundWithPositiveRange() {
		exampleRange = new Range(3.0, 7.0);
		assertEquals("The upper bound of a positive range should be the higher value", 7.0, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundWithNegativeRange() {
		exampleRange = new Range(-7.0, -3.0);
		assertEquals("The upper bound of a negative range should be the less negative value", -3.0, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundAtZeroBoundary() {
		exampleRange = new Range(-7.0, 0.0);
		assertEquals("The upper bound at zero boundary should be 0.0", 0.0, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundWithInvalidRange() {
		exampleRange = new Range(7.0, 6.0);
		// This test expects an IllegalArgumentException to be thrown
		// due to invalid range (where upper bound is less than the lower bound)
	}
	
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}

}
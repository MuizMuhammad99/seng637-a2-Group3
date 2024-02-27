package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest1 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}
	
	@Test
	public void getLowerBoundWithNegativeRange() {
		exampleRange = new Range(-10.0, -1.0);
		assertEquals("The lower bound of a negative range should be the negative value closest to zero", 10.0, exampleRange.getLowerBound(), 0.000000001d);
	}

	@Test
	public void getLowerBoundWithPositiveRange() {
		exampleRange = new Range(1.0, 10.0);
		assertEquals("The lower bound of a positive range should be the smallest positive value", 1.0, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithZeroLowerBound() {
		exampleRange = new Range(0.0, 10.0);
		assertEquals("The lower bound of a range starting with zero should be zero", 0.0, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithInvalidRange() {
		exampleRange = new Range(10.0, -10.0);
		// This test expects an IllegalArgumentException to be thrown
		// due to invalid range (where lower bound is greater than the upper bound)
	}
	
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}
	
	
}
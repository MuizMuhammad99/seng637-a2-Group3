package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeCombineTest
{
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void bothNullRangeReturnsNull() {
    	
        assertNull("The range should be null since both ranges are null",
        Range.combine(null, null));
    }
    
    @Test
    public void firstNullRangeReturnsSecond() {
    	Range range1 = new Range (-10, 10);
        assertEquals("The second range should be returned since first is null",
        range1, Range.combine(null, range1));
    }
    
    @Test
    public void secondNullRangeReturnsFirst() {
    	Range range1 = new Range (1, 10);
        assertEquals("The first range should be returned since second is null",
        range1, Range.combine(range1, null));
    }
    
    @Test
    public void bothRangesOverlapping() {
    	Range range1 = new Range (1, 10);
    	Range range2 = new Range (-2, 5);
    	Range expected = new Range (-2, 10);
        assertEquals("The expected range should be (-2, 10)",
        expected, Range.combine(range1, range2));
    }
    
    @Test
    public void bothRangesNotOverlapping() {
    	Range range1 = new Range (1, 10);
    	Range range2 = new Range (-20, -10);
    	Range expected = new Range (-20, 10);
        assertEquals("The expected range should be (-20, 10)",
        expected, Range.combine(range1, range2));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}

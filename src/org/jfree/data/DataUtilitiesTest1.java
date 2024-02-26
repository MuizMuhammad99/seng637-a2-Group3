package org.jfree.data;

import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest1 {
	
	private Mockery mockingContext;
	private Values2D values;
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	}
    
	@Test
    public void calculateRowTotalForTwoValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(2)); // assuming there are two columns
            oneOf(values).getValue(0, 0);
            will(returnValue(5.0));
            oneOf(values).getValue(0, 1);
            will(returnValue(3.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);

        // verify
        assertEquals(8.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test
    public void calculateRowTotalForEmptyRow() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(0)); // assuming there are no columns
            
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);

        // verify
        assertEquals(0.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test
    public void calculateRowTotalForSingleValue() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(1)); // assuming there is only one column
            oneOf(values).getValue(0,0);
            will(returnValue(5.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);

        // verify
        assertEquals(5.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test
    public void calculateRowTotalForNullData() {
        DataUtilities.calculateRowTotal(null, 0);
        // Throws an InvalidParameterException
	}
	
	@Test
    public void calculateRowTotalWithMixedValues() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(3)); // assuming there are three columns
            oneOf(values).getValue(0,0);
            will(returnValue(5.0));
            oneOf(values).getValue(0,1);
            will(returnValue(-3.0));
            oneOf(values).getValue(0,2);
            will(returnValue(10.0));
        }});

        // exercise
        double result = DataUtilities.calculateRowTotal(values, 0);

        // verify
        assertEquals(12.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@After
	public void tearDown() throws Exception {
		mockingContext.assertIsSatisfied();
	}
}
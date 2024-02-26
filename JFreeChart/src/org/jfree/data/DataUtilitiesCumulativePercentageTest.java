package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesCumulativePercentageTest {

	private Mockery mockingContext;
    private KeyedValues values;
    
    
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        mockingContext = new Mockery();
        values = mockingContext.mock(KeyedValues.class);
    }

    @Test
    public void calculateCumulativePercentageForOneValues() {

       mockingContext.checking(new Expectations() {{
    	   allowing(values).getItemCount();
           will(returnValue(1));
	       allowing(values).getKey(0);
	       will(returnValue(0));
	       allowing(values).getValue(0);
	       will(returnValue(5));
	       }});
	
	       // exercise
	       KeyedValues result = DataUtilities.getCumulativePercentages(values);
	
	       // verify
	       assertEquals("The percentage for 1 value should be 1.0", 1.0, result.getValue(0).doubleValue());
    }
    
    @Test
    public void calculateCumulativePercentageForThreeValues() {

        mockingContext.checking(new Expectations() {{
            allowing(values).getItemCount();
            will(returnValue(3));
 	        allowing(values).getKey(0);
 	        will(returnValue(0));
        	allowing(values).getValue(0);
            will(returnValue(5));
 	        allowing(values).getKey(1);
 	        will(returnValue(1));
            allowing(values).getValue(1);
            will(returnValue(9));
 	        allowing(values).getKey(2);
 	        will(returnValue(2));
            allowing(values).getValue(2);
            will(returnValue(2));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        // verify
        assertEquals("The percentage for 1/3 value should be 0.3125", 0.3125, result.getValue(0).doubleValue());
        assertEquals("The percentage for 2/3 value should be 0.875", 0.875, result.getValue(1).doubleValue());
        assertEquals("The percentage for 3/3 value should be 1.0", 1.0, result.getValue(2).doubleValue());
    }
    
    @Test
    public void calculateCumulativePercentageForNullData() {

        mockingContext.checking(new Expectations() {{
        	allowing(values).getItemCount();
            will(returnValue(1));
 	        allowing(values).getKey(0);
 	        will(returnValue(0));
            allowing(values).getValue(0);
            will(returnValue(null));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        // verify
        assertEquals("The percentage for null value should be NaN", Double.NaN, result.getValue(0));
    }

    @Test
    public void calculateCumulativePercentageForInvalidData() {

        mockingContext.checking(new Expectations() {{
        	allowing(values).getItemCount();
            will(returnValue(1));
 	        allowing(values).getKey(0);
 	        will(returnValue(0));
            allowing(values).getValue(0);
            will(returnValue('A'));
        }});

        // exercise
        KeyedValues result = DataUtilities.getCumulativePercentages(values);

        // verify
        assertEquals("The percentage for invalid value should be error", Double.NaN, result.getValue(0));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilitiesCreateNumberArray {

	@Test(expected = IllegalArgumentException.class)
    public void createNumberArrayInvalidType() {
       Number[] dataCreated =  {1.0, 2.0, 3.0, 4.0, 5.0};
       Number[] dataExpected = DataUtilities.createNumberArray(null);
       
       //assertEquals("InvalidParameterException", dataCreated, dataExpected);
    }
    
    @Test
    public void createNumberArrayEmptyArray() {
       double[] dataCreated =  {};
       Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
       
       assertArrayEquals(new Number[]{}, dataExpected);
    }
    
    @Test
    public void createNumberArrayExtremeValues() {
       double[] dataCreated =  {-Double.MAX_VALUE, -5.0,  0.0, 5.0, Double.MAX_VALUE};
       Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
       
       assertArrayEquals(new Number[]{-Double.MAX_VALUE, -5.0,  0.0, 5.0, Double.MAX_VALUE}, dataExpected);
    }
    
    @Test
    public void createNumberArrayDifferentTypes() {
        double[] dataCreated =  {-5.0, 0.0, 5.0};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        //assertArrayEquals(new Number[]{-5, 0, 5}, dataExpected);
        assertNotSame(new Number[]{-5, 0, 5}, dataExpected);
     }

}

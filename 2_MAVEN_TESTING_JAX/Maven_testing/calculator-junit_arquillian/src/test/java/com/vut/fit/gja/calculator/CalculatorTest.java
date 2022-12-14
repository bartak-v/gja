package com.vut.fit.gja.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*
 * The test suit class does not need to implement any interface or extend any 
 * class
 * Test methods are marked with imported annotation @Test
 */
/**
 * JUnit test class for Calculator component
 */
public class CalculatorTest {

    /**
     * Basic test of calculator add method
     */
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();

        Assertions.assertEquals(5, calculator.add(2, 3));
    }

    /**
     * Basic test of calculator divide method
     */
    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();

        // test division result
        Assertions.assertEquals(5, calculator.divide(10, 2));

        try {

            // if an exception is expected, it is possible to use fail
            // method to fail the test if the exception was not thrown
            calculator.divide(10, 0);
            Assertions.fail("Expected exception was not thrown");
        } catch (Exception e) {
        }
    }
}

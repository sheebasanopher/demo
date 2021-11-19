package com.sheeba.app;

import com.sheeba.app.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSub() {
        int result = calculator.sub(10, 5);
        assertEquals(5, result);

    }

    @Test
    public void testMultiple() {
        int result = calculator.multiple(20, 5);
        assertEquals(100, result);
    }
    @Test
    public void testDivide(){
        int result =calculator.divide(4,2);
        assertEquals(2,result);
    }

}



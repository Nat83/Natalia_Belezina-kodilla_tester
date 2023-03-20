package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        assertEquals(13, sumResult);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int subtractResult = calculator.subtract(a, b);
        assertEquals(-3, subtractResult);
    }

    @Test
    public void testRiseToPower() {
        Calculator calculator = new Calculator();
        double a = 3.5;
        double b = 4;
        double delta = 0.0025;
        double riseToPowerResult = calculator.riseToPower(a, b);
        assertEquals(150.06, riseToPowerResult, delta);
    }
}
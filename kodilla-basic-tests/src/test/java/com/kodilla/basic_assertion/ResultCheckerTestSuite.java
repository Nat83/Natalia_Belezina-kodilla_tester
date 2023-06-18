package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultCheckerTestSuite {
    private int number1;
    private int number2;

    private int number3;

    @BeforeEach
    void setUp() {
        number1 = 2;
        number2 = 2;
        number3 = 3;

    }

    @Test
    void theSameNumbersShouldEquals() {
        Assertions.assertTrue(ResultChecker.assertEquals(number1, number2));
    }

    @Test
    void differentNumbersShouldEquals() {
        Assertions.assertFalse(ResultChecker.assertEquals2(number3, number2));
    }
}
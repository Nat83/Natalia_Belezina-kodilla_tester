package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GamblingMachineTestSuite {
    private GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/validatedUserNumbers.csv", numLinesToSkip = 1)
    public void returnCorrectNumberOfWinsIfNumbersValidated(Set<Integer> userNumbers) throws InvalidNumbersException {
        assertTrue(gamblingMachine.howManyWins(userNumbers) >0 && gamblingMachine.howManyWins(userNumbers) < 6);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbersIncorrectSetSize.csv", numLinesToSkip = 1)
    public void returnErrorMessageWhenTooManyNumbersInSet(Set<Integer> userNumbers) throws InvalidNumbersException {
        assertEquals(new InvalidNumbersException(), gamblingMachine.howManyWins(userNumbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbersOutOfScope.csv", numLinesToSkip = 1)
    public void returnErrorMessageWhenNumbersOutOfScope(Set<Integer> userNumbers) throws InvalidNumbersException {
        assertThrows(InvalidNumbersException.class, () -> gamblingMachine.howManyWins(userNumbers));
//        assertEquals(new InvalidNumbersException(), gamblingMachine.howManyWins(userNumbers));
    }
}
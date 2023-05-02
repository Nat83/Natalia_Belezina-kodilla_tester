package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GamblingMachineTestSuite {
    private GamblingMachine gamblingMachine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/validatedUserNumbers.csv", numLinesToSkip = 1)
    public void returnCorrectNumberOfWinsIfNumbersValidated(String userNumbers) throws InvalidNumbersException {
        Set<Integer> numbers = convertStringToSet(userNumbers);
        assertTrue(gamblingMachine.howManyWins(numbers) >=0 && gamblingMachine.howManyWins(numbers) < 6);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbersIncorrectSetSize.csv", numLinesToSkip = 1)
    public void returnErrorMessageWhenTooManyNumbersInSet(String userNumbers) throws InvalidNumbersException {
        Set<Integer> numbers = convertStringToSet(userNumbers);
        assertThrows(InvalidNumbersException.class, () -> gamblingMachine.howManyWins(numbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/numbersOutOfScope.csv", numLinesToSkip = 1)
    public void returnErrorMessageWhenNumbersOutOfScope(String userNumbers) throws InvalidNumbersException {
        Set<Integer> numbers = convertStringToSet(userNumbers);
        assertThrows(InvalidNumbersException.class, () -> gamblingMachine.howManyWins(numbers));
    }
    private static Set<Integer> convertStringToSet(String userNumbers) {
        String[] splittedString = userNumbers.split(" ");
        Set<Integer> numbers = new HashSet<>();
        for(String s : splittedString){
            numbers.add(Integer.valueOf(s));
        }
        return numbers;
    }

}
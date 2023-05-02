package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTestSuite {

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.homework.BMISources#providePersonsForBMITest")
    public void shouldReturnCorrectBMIForDifferentPeople(Person person, String expected) {
        assertEquals(expected, person.getBMI());
    }

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.homework.BMISources#providePersonsForIncorrectBMITest")
    public void shouldNotReturnIncorrectMessageForGivenBMI(Person person, String expected) {
        assertNotEquals(expected,person.getBMI());
    }

    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.homework.BMISources#providePersonsForIncorrectBMIZeroValues")
    public void shouldReturnErrorWhenIncorrectWeightProvided(Person person, InvalidDataException expected) throws Exception {
        if (person.getHeightInMeters()==0 && person.getWeightInKilogram()==0){
            throw new InvalidDataException();
        }
        assertThrows(InvalidDataException.class, () -> person.getBMI());
    }
}
package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTestSuite {

    private UserValidator validator = new UserValidator();
//    @ParameterizedTest
//    @CsvSource(value = {"test-123,true", "TEST.123,true", "-._,true", "AAAAAAAAaaaaaaaaaaaa5555555 ,true"})
//    public void shouldReturnTrueForUserNamesWihPermittedSigns(String input, boolean expected) {
//        assertEquals(expected, validator.validateUsername(input));
//    }

//    @ParameterizedTest
//    @CsvSource(value = {"1@Nat,false", "40.Nat*,false", "<nat>_,false", "/nAT ,false", "{nat77},false"})
//    public void shouldReturnFalseForUserNamesWihNoPermittedSigns(String input, boolean expected) {
//        assertEquals(expected, validator.validateUsername(input));
//    }

//    @ParameterizedTest
//    @CsvSource(value = {"1_,false", "9,false", ".a,false", "-0 ,false", "A,false"})
//    public void shouldReturnFalseForUsersWihTooShortName(String input, boolean expected) {
//        assertEquals(expected, validator.validateUsername(input));
//    }

    @ParameterizedTest
    @CsvSource(value = {"test,4", " OtHEr ,5", "E V e n t,5", "null ,4", "A,1"})
    public void shouldReturnTrueForEmailsWithPermittedSigns(String input, boolean expected) {
        assertEquals(expected, validator.validateEmail(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"test,4", " OtHEr ,5", "E V e n t,5", "null ,4", "A,1"})
    public void shouldReturnFalseForEmailsWithNoPermittedSigns(String input, boolean expected) {
        assertEquals(expected, validator.validateEmail(input));
    }

}
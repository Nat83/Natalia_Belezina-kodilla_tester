package com.kodilla.parametrized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTestSuite {
    private StringManipulator manipulator = new StringManipulator();
    @ParameterizedTest
//    @CsvSource(value = {"test,tset", "OtHEr,rehto", "EVent,tneve", "null,llun", "A,a"})
    @CsvFileSource(resources = "/stringWithLowerCase.csv", numLinesToSkip = 1)
    public void shouldReverseStringWithLowerCase(String input, String expected) {
        assertEquals(expected, manipulator.reverseWithLowerCase(input));
    }

    //pobieranie danych z metody napisanej w osobnej klasie
    @ParameterizedTest
    @MethodSource(value = "com.kodilla.parametrized_tests.StringSources#provideStringsForTestingLength")
    public void shouldCalculateStringLengthWithoutSpaces(String input, int expected) {
        assertEquals(expected, manipulator.getStringLengthWithoutSpaces(input));
    }

    //drugi sposob - pobiranie danych z metody ponizej
//    @ParameterizedTest
//    @MethodSource
//    public void shouldCalculateStringLengthWithoutSpaces(String input, int expected) {
//        assertEquals(expected, manipulator.getStringLengthWithoutSpaces(input));
//    }
//
//    private static Stream<Arguments> shouldCalculateStringLengthWithoutSpaces() {
//        return Stream.of(
//                Arguments.of("test", 4),
//                Arguments.of("OtHEr ", 5),
//                Arguments.of("E V e n t", 5),
//                Arguments.of("null ", 4),
//                Arguments.of("A", 1)
//        );
//    }

     //kolejny sposob -  pobieranie danych z Csv source
//    @ParameterizedTest
//    @CsvSource(value = {"test,4", " OtHEr ,5", "E V e n t,5", "null ,4", "A,1"})
//    public void shouldCalculateStringLengthWithoutSpaces(String input, int expected) {
//        assertEquals(expected, manipulator.getStringLengthWithoutSpaces(input));
//    }

    @ParameterizedTest
    @CsvSource(value = {"te,st:1", "..OtHEr :0", "E,V,e,n.t:3", "null :0", "A:0"}, delimiter = ':')
//    @CsvFileSource(resources = "/numbersOfCommas.csv", numLinesToSkip = 1)
    public void shouldCountNumberOfCommas(String input, int expected) {
        assertEquals(expected, manipulator.countNumberOfCommas(input));
    }

}
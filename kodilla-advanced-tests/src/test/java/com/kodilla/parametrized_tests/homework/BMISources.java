package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class BMISources {
    static Stream<Arguments> providePersonsForBMITest() {
        return Stream.of(
                Arguments.of(new Person(1.62, 67), "Overweight"),
                Arguments.of(new Person(1.42, 100),
                        "Obese Class IV (Morbidly Obese)"),
                Arguments.of(new Person(1.50, 95),
                        "Obese Class III (Very severely obese)"),
                Arguments.of(new Person(1.47, 80),
                        "Obese Class II (Severely obese)"),
                Arguments.of(new Person(1.60, 80),
                        "Obese Class I (Moderately obese)"),
                Arguments.of(new Person(1.60, 38), "Very severely underweight"),
                Arguments.of(new Person(1.70, 45), "Severely underweight"),
                Arguments.of(new Person(1.80, 60), "Normal (healthy weight)"),
                Arguments.of(new Person(1.91, 66), "Underweight"),
                Arguments.of(new Person(1.70, 160), "Obese Class V (Super Obese)"),
                Arguments.of(new Person(1.70, 180), "Obese Class VI (Hyper Obese)")
        );
    }
    static Stream<Arguments> providePersonsForIncorrectBMITest() {
        return Stream.of(
                Arguments.of(new Person(1.62, 67),
                        "Very severely underweight"),
                Arguments.of(new Person(1.42, 100),
                        "Severely underweight"),
                Arguments.of(new Person(1.50, 95),
                        "Normal (healthy weight)"),
                Arguments.of(new Person(1.47, 80),
                        "Underweight"),
                Arguments.of(new Person(1.60, 80),
                        "Obese Class V (Super Obese)"),
                Arguments.of(new Person(1.60, 38),
                        "Overweight"),
                Arguments.of(new Person(1.70, 45),
                        "Obese Class IV (Morbidly Obese)"),
                Arguments.of(new Person(1.80, 60),
                        "Obese Class III (Very severely obese)"),
                Arguments.of(new Person(1.91, 66),
                        "Obese Class II (Severely obese)"),
                Arguments.of(new Person(1.70, 160),
                        "Obese Class VI (Hyper Obese)"),
                Arguments.of(new Person(1.70, 180),
                        "Obese Class I (Moderately obese)")
        );
    }

    static Stream<Arguments> providePersonsForIncorrectBMIZeroValues() throws InvalidDataException{
        return Stream.of(
                Arguments.of(new Person(0, 0), new InvalidDataException()),
                Arguments.of(new Person(160, 0), new InvalidDataException()),
                Arguments.of(new Person(0, 60), new InvalidDataException())
        );
    }
}

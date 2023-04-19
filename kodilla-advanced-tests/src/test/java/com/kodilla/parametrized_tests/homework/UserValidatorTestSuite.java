package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTestSuite {

    private UserValidator userValidator = new UserValidator();

    @ParameterizedTest
    @CsvSource(value = {"test-123", "TEST.123", "-._", "AAAAAAAAaaaaaa55555", "AAA", "aaa", "123", "---", "___", "..."})
    public void shouldReturnTrueForUserNamesWihPermittedSigns(String input) {
        assertTrue(userValidator.validateUsername(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1@Nat", "40.Nat*", "<nat>", "/nAT", "{nat77}"})
    public void shouldReturnFalseForUserNamesWihNoPermittedSigns(String input) {
        assertFalse(userValidator.validateUsername(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1_", "9", ".a", "-0", "A", "55", "Ac", "AA", "aa"})
    public void shouldReturnFalseForUsersWihTooShortName(String input) {
        assertFalse(userValidator.validateUsername(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"nat_b@gsoft.com", "NAT-B@g-soft.pl", "66-aa_Nat.aa-44_7@gSOFT.com", "_-_.-_-@--.pl",
            "AAA.AAA@AAA.c", "aaa.aaa@aaa.comcom", "66-33.77_88@99-11.99-11.GB"})
    public void shouldReturnTrueForEmailsWithCorrectFormat(String input) {
        assertTrue(userValidator.validateEmail(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"nat_bgsoft.com", "NAT-B@g-softpl", "66-aa_Nat.aa-44_7@gSOFT_SOFT.com", "_-_.-_-@-_-.pl",
            "M@LPA@AAA.c", "aaa.aaa@aaa.comcomm", "66+33.77=88@99-11.99-11.GB"})
    public void shouldReturnFalseForEmailsWithIncorrectFormat(String input) {
        assertFalse(userValidator.validateEmail(input));
    }
}
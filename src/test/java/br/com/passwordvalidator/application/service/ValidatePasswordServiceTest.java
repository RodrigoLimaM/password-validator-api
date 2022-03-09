package br.com.passwordvalidator.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatePasswordServiceTest {

    private final ValidatePasswordService validatePasswordService;

    ValidatePasswordServiceTest() {
        this.validatePasswordService = new ValidatePasswordService();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Abcdefg!1",
            "Abcdefg@1",
            "Abcdefg#1",
            "Abcdefg$1",
            "Abcdefg%1",
            "Abcdefg^1",
            "Abcdefg&1",
            "Abcdefg*1",
            "Abcdefg(1",
            "Abcdefg)1",
            "Abcdefg-1",
            "Abcdefg+1"})
    void shouldReturnTrue_whenPasswordIsValid(final String password) {
        final boolean expected = true;

        final boolean actual = validatePasswordService.validatePassword(password);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Abcdfg@1",
            "Abcdfgh@",
            "abcdefg@1",
            "ABCDEFG@1",
            "ABCDEFGH1",
            "AAcdefg@1",
            "ABCD EFGH1"})
    void shouldReturnFalse_whenPasswordDoesntMeetTheRequirements(final String password) {
        final boolean expected = false;

        final boolean actual = validatePasswordService.validatePassword(password);

        assertEquals(expected, actual);
    }

}

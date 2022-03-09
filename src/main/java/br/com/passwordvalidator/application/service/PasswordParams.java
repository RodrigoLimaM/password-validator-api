package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
class PasswordParams {

    private final String password;

    @Setter
    private boolean isValid;

    public static PasswordParams of(final String password) {
        return new PasswordParams(password, false);
    }
}

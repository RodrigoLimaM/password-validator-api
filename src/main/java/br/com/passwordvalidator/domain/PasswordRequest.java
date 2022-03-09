package br.com.passwordvalidator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class PasswordRequest {

    private final String password;

    @Setter
    private boolean isValid;

    public static PasswordRequest of(final String password) {
        return new PasswordRequest(password, false);
    }
}

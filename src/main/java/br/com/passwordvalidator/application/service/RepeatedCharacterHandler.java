package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class RepeatedCharacterHandler extends AbstractPasswordValidationHandler {

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasNotRepeatedCharacter(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasNotRepeatedCharacter(final String password) {
        return password.length() == password.chars()
                .distinct()
                .count();
    }

}

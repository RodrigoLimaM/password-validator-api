package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UppercaseLetterHandler extends AbstractPasswordValidationHandler {

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasUppercaseLetter(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasUppercaseLetter(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isUpperCase);
    }

}

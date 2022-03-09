package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DigitHandler extends AbstractPasswordValidationHandler {

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasAtLeastOneDigit(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasAtLeastOneDigit(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isDigit);
    }

}

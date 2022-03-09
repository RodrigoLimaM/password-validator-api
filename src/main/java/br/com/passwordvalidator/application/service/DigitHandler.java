package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class DigitHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasAtLeastOneDigit(passwordRequest.getPassword()));
    }

    private boolean hasAtLeastOneDigit(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isDigit);
    }

}

package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class DigitHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasAtLeastOneDigit(passwordParams.getPassword()));
    }

    private boolean hasAtLeastOneDigit(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isDigit);
    }

}

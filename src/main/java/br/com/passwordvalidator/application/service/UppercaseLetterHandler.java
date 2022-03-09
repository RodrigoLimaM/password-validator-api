package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class UppercaseLetterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasUppercaseLetter(passwordParams.getPassword()));
    }

    private boolean hasUppercaseLetter(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isUpperCase);
    }

}

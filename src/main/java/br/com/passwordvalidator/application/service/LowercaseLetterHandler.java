package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class LowercaseLetterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasLowercaseLetter(passwordParams.getPassword()));
    }

    private boolean hasLowercaseLetter(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isLowerCase);
    }

}

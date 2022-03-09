package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class WhitespaceCharacterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasNotWhitespaceCharacter(passwordParams.getPassword()));
    }

    private boolean hasNotWhitespaceCharacter(final String password) {
        return !super.hasSomeConditionOnCharacters(password, Character::isSpaceChar);
    }

}

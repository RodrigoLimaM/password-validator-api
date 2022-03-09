package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class WhitespaceCharacterHandler extends AbstractPasswordValidationHandler {

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasNotWhitespaceCharacter(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasNotWhitespaceCharacter(final String password) {
        return !super.hasSomeConditionOnCharacters(password, Character::isSpaceChar);
    }

}

package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
class SpecialCharacterHandler extends AbstractPasswordValidationHandler {

    private static final Set<Character> SPECIAL_CHARACTERS = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasSpecialCharacter(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasSpecialCharacter(final String password) {
        return super.hasSomeConditionOnCharacters(password, character -> SPECIAL_CHARACTERS.contains((char) character));
    }

}

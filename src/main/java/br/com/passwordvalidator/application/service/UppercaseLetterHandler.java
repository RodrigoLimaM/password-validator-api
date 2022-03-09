package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UppercaseLetterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasUppercaseLetter(passwordRequest.getPassword()));
    }

    private boolean hasUppercaseLetter(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isUpperCase);
    }

}

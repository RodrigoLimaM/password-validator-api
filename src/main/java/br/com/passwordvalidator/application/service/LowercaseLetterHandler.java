package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LowercaseLetterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasLowercaseLetter(passwordRequest.getPassword()));
    }

    private boolean hasLowercaseLetter(final String password) {
        return super.hasSomeConditionOnCharacters(password, Character::isLowerCase);
    }

}

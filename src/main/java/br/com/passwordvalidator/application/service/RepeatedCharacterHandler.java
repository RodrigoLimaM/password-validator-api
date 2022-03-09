package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class RepeatedCharacterHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasNoRepeatedCharacter(passwordParams.getPassword()));
    }

    private boolean hasNoRepeatedCharacter(final String password) {
        return password.length() == password.chars()
                .distinct()
                .count();
    }

}

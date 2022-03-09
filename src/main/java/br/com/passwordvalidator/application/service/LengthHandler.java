package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class LengthHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasMoreThanNineCharacters(passwordParams.getPassword()));
    }

    private boolean hasMoreThanNineCharacters(final String password) {
        return password.length() > 8;
    }

}

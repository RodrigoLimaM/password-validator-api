package br.com.passwordvalidator.application.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class LengthHandler extends AbstractPasswordValidationHandler {

    public static final int MINIMUM_LENGTH = 8;

    @Override
    public void execute(final PasswordParams passwordParams) {
        passwordParams.setValid(hasMoreThanNineCharacters(passwordParams.getPassword()));
    }

    private boolean hasMoreThanNineCharacters(final String password) {
        return password.length() > MINIMUM_LENGTH;
    }

}

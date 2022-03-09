package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LengthHandler extends AbstractPasswordValidationHandler {

    @Override
    public PasswordRequest execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasMoreThanNineCharacters(passwordRequest.getPassword()));
        return passwordRequest;
    }

    private boolean hasMoreThanNineCharacters(final String password) {
        return password.length() > 8;
    }

}

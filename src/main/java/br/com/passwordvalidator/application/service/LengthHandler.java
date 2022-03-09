package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class LengthHandler extends AbstractPasswordValidationHandler {

    @Override
    public void execute(final PasswordRequest passwordRequest) {
        passwordRequest.setValid(hasMoreThanNineCharacters(passwordRequest.getPassword()));
    }

    private boolean hasMoreThanNineCharacters(final String password) {
        return password.length() > 8;
    }

}

package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.application.port.in.ValidatePasswordUseCase;
import br.com.passwordvalidator.domain.PasswordRequest;
import org.springframework.stereotype.Service;

@Service
class ValidatePasswordService implements ValidatePasswordUseCase {

    private final AbstractPasswordValidationHandler abstractPasswordValidationHandler;

    ValidatePasswordService() {
        abstractPasswordValidationHandler = new LengthHandler();
        abstractPasswordValidationHandler.setNext(new DigitHandler())
                .setNext(new LowercaseLetterHandler())
                .setNext(new UppercaseLetterHandler())
                .setNext(new SpecialCharacterHandler())
                .setNext(new RepeatedCharacterHandler())
                .setNext(new WhitespaceCharacterHandler());
    }

    @Override
    public boolean validatePassword(final String password) {
        return abstractPasswordValidationHandler.handle(PasswordRequest.of(password));
    }
}

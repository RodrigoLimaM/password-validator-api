package br.com.passwordvalidator.application.port.in;

public interface ValidatePasswordUseCase {

    boolean validatePassword(final String password);
}

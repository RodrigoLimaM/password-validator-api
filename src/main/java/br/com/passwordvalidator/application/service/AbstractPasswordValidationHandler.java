package br.com.passwordvalidator.application.service;

import br.com.passwordvalidator.domain.PasswordRequest;

import java.util.function.IntPredicate;

abstract class AbstractPasswordValidationHandler {

    private AbstractPasswordValidationHandler next;

    AbstractPasswordValidationHandler setNext(final AbstractPasswordValidationHandler abstractPasswordValidationHandler) {
        this.next = abstractPasswordValidationHandler;
        return next;
    }

    abstract void execute(final PasswordRequest passwordRequest);

    boolean handle(final PasswordRequest passwordRequest) {
        this.execute(passwordRequest);
        if(passwordRequest.isValid() && next != null)
            return next.handle(passwordRequest);
        return passwordRequest.isValid();
    }

    boolean hasSomeConditionOnCharacters(final String password, final IntPredicate condition) {
        return password.chars()
                .anyMatch(condition);
    }

}

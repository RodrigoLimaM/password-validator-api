package br.com.passwordvalidator.application.service;

import java.util.function.IntPredicate;

abstract class AbstractPasswordValidationHandler {

    private AbstractPasswordValidationHandler next;

    AbstractPasswordValidationHandler setNext(final AbstractPasswordValidationHandler abstractPasswordValidationHandler) {
        this.next = abstractPasswordValidationHandler;
        return next;
    }

    abstract void execute(final PasswordParams passwordParams);

    boolean handle(final PasswordParams passwordParams) {
        this.execute(passwordParams);
        if(passwordParams.isValid() && next != null)
            return next.handle(passwordParams);
        return passwordParams.isValid();
    }

    boolean hasSomeConditionOnCharacters(final String password, final IntPredicate condition) {
        return password.chars()
                .anyMatch(condition);
    }

}

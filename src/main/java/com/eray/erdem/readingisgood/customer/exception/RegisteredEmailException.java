package com.eray.erdem.readingisgood.customer.exception;

public class RegisteredEmailException extends RuntimeException {
    private static final String REGISTERED_EMAIL_ACCOUNT = "Registred email account %s";

    public RegisteredEmailException(String email) {
        super(String.format(REGISTERED_EMAIL_ACCOUNT, email));
    }
}

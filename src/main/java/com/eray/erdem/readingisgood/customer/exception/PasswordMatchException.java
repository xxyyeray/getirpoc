package com.eray.erdem.readingisgood.customer.exception;

public class PasswordMatchException extends RuntimeException {
    private static final String PASSWORD_MATCH = "Passwords do not match. password is %s passwordMatch is %s";

    public PasswordMatchException(String password, String passwordMatch) {
        super(String.format(PASSWORD_MATCH, password, passwordMatch));
    }
}

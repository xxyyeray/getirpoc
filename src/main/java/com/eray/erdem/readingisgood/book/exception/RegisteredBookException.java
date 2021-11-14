package com.eray.erdem.readingisgood.book.exception;

public class RegisteredBookException extends RuntimeException {
    private static final String REGISTERED_BOOK = "Registered book isbn received %s";

    public RegisteredBookException(String isbn) {
        super(String.format(REGISTERED_BOOK, isbn));
    }
}

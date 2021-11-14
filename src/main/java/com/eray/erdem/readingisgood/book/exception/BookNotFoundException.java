package com.eray.erdem.readingisgood.book.exception;

public class BookNotFoundException extends RuntimeException {
    public static final String BOOK_NOT_FOUND = "The book belonging to the entered isbn could not be found . isbn is %s";

    public BookNotFoundException(String isbn) {
        super(String.format(BOOK_NOT_FOUND, isbn));
    }
}

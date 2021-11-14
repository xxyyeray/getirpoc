package com.eray.erdem.readingisgood.book.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(int amount, int stock, String isbn) {
        super(isbn);
    }
}

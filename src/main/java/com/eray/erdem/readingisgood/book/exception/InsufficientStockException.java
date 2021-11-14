package com.eray.erdem.readingisgood.book.exception;

public class InsufficientStockException extends RuntimeException {

    public static final String INSUFFICIENT_STOCK = "insufficient stock . amount = %s stock = %s isbn = %s";

    public InsufficientStockException(int amount, int stock, String isbn) {
        super(String.format(INSUFFICIENT_STOCK, amount, stock, isbn));
    }
}

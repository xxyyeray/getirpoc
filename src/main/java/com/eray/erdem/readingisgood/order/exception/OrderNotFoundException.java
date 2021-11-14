package com.eray.erdem.readingisgood.order.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderNotFoundException extends RuntimeException {

    public static final String ORDER_NOT_FOUND = "Order not found . %s";

    public OrderNotFoundException(String id) {

        super(String.format(ORDER_NOT_FOUND, id));
    }
}


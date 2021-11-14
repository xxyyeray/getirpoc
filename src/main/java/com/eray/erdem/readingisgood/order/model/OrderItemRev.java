package com.eray.erdem.readingisgood.order.model;

import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemRev {
    @ISBN(message = "set valid isbn format")
    @NotNull(message = "name can not be null")
    private String isbn;


    @Min(value = 0, message = "stock size must be bigger than -1")
    @NotNull(message = "stock can not be null")
    private Integer amount;

}

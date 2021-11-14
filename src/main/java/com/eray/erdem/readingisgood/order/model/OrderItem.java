package com.eray.erdem.readingisgood.order.model;

import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Valid
public class OrderItem {
    @ISBN(message = "set valid isbn format")
    @NotNull(message = "name can not be null")
    private String isbn;


    @Min(value = 0, message = "amount size must be bigger than -1")
    @NotNull(message = "amount can not be null")
    private Integer amount;

    private Double price;


}

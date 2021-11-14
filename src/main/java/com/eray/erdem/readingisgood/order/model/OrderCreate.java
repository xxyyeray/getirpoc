package com.eray.erdem.readingisgood.order.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderCreate {

    @NotBlank
    private String customerNumber;

    @NotEmpty
    @Valid
    private List<OrderItem> books;
}

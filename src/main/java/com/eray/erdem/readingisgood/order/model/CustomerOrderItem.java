package com.eray.erdem.readingisgood.order.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerOrderItem {
    private String customerId;
    private List<Asd> orders;

}

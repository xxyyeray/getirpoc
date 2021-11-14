package com.eray.erdem.readingisgood.order.model;


import lombok.Data;

import java.util.List;

@Data
public class OrderInjection {

    private String customerNumber;
    private List<CustomerOrderItem> items;
}



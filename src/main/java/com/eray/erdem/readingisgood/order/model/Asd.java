package com.eray.erdem.readingisgood.order.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Asd {
    private Date orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> items;


}

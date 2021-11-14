package com.eray.erdem.readingisgood.order.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private Date orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> items;


}

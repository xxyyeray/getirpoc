package com.eray.erdem.readingisgood.order.model;


import com.eray.erdem.readingisgood.customer.model.Customer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("order")
@Data
@Builder
public class Order {

    @Id
    private String id;
    @DBRef
    private Customer customer;
    private Date orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> items;

}


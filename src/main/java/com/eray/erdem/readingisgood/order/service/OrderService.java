package com.eray.erdem.readingisgood.order.service;

import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.model.OrderCreate;
import com.eray.erdem.readingisgood.order.model.OrderDetail;

import java.util.Date;
import java.util.List;

public interface OrderService {


    OrderDetail createOrder(OrderCreate orderCreate);

    Order getOrder(String id);

    List<Order> getOrdersByDate(Date startDate, Date endDate);
}

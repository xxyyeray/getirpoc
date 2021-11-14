package com.eray.erdem.readingisgood.order.controller;


import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.model.OrderCreate;
import com.eray.erdem.readingisgood.order.model.OrderDetail;
import com.eray.erdem.readingisgood.order.model.OrderQuery;
import com.eray.erdem.readingisgood.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "orders")
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetail createOrder(@Valid @RequestBody OrderCreate orderCreate) {
        return orderService.createOrder(orderCreate);
    }

    @GetMapping("{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }


    @PostMapping("query")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(@Valid @RequestBody OrderQuery orderCreate) {
        return orderService.getOrdersByDate(orderCreate.getStartDate(), orderCreate.getEndDate());
    }


}

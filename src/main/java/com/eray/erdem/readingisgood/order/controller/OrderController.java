package com.eray.erdem.readingisgood.order.controller;


import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.model.OrderCreate;
import com.eray.erdem.readingisgood.order.model.OrderDetail;
import com.eray.erdem.readingisgood.order.model.OrderQuery;
import com.eray.erdem.readingisgood.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX;
import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX_ERROR_MESSAGE;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "orders")
@Validated
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetail createOrder(@Valid @RequestBody OrderCreate orderCreate) {
        return orderService.createOrder(orderCreate);
    }

    @GetMapping("{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder(@PathVariable @NotNull @Pattern(regexp = ISBN_REGEX, message = ISBN_REGEX_ERROR_MESSAGE) String orderId) {
        return orderService.getOrder(orderId);
    }


    @PostMapping("query")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrders(@Valid @RequestBody OrderQuery orderCreate) {
        return orderService.getOrdersByDate(orderCreate.getStartDate(), orderCreate.getEndDate());
    }


}

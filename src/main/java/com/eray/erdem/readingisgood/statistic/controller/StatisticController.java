package com.eray.erdem.readingisgood.statistic.controller;


import com.eray.erdem.readingisgood.order.model.OrderDetail;
import com.eray.erdem.readingisgood.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "statistics")
public class StatisticController {


    private final StatisticService orderService;

    @GetMapping("{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDetail createOrder(@PathVariable String customerId) {
        orderService.getOrdersByDate(customerId);
        return null;
    }


}

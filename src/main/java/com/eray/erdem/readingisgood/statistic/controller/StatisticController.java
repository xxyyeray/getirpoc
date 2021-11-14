package com.eray.erdem.readingisgood.statistic.controller;


import com.eray.erdem.readingisgood.statistic.Statistic;
import com.eray.erdem.readingisgood.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX;
import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX_ERROR_MESSAGE;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "statistics")
public class StatisticController {


    private final StatisticService orderService;

    @GetMapping("{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Statistic> createOrder(@PathVariable @NotNull @Pattern(regexp = ISBN_REGEX, message = ISBN_REGEX_ERROR_MESSAGE) String customerId) {
        return orderService.getOrdersByDate(customerId);

    }


}

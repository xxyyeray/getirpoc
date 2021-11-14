package com.eray.erdem.readingisgood.customer.controller;


import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;
import com.eray.erdem.readingisgood.customer.service.CustomerService;
import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX;
import static com.eray.erdem.readingisgood.constant.ApiConstant.ISBN_REGEX_ERROR_MESSAGE;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "customers")
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerCreateResponse createCustomer(@Valid @RequestBody CustomerCreate customer) {
        return customerService.persistCustomer(customer);
    }

    @GetMapping("{customerId}/orders/{page}")
    public CustomerOrderItem getBooksOfCustomer(@PathVariable @NotNull @Pattern(regexp = ISBN_REGEX, message = ISBN_REGEX_ERROR_MESSAGE) String customerId, @PositiveOrZero @PathVariable int page) {
        return customerService.getOrdersOfCustomer(customerId, page);


    }
}

package com.eray.erdem.readingisgood.customer.controller;


import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;
import com.eray.erdem.readingisgood.customer.service.CustomerService;
import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerCreateResponse createCustomer(@Valid @RequestBody CustomerCreate customer) {
        return customerService.persistCustomer(customer);
    }

    @GetMapping("{customerId}/orders/{page}")
    public CustomerOrderItem getBooksOfCustomer(@PathVariable String customerId, @PathVariable int page) {
        return customerService.getOrdersOfCustomer(customerId, page);


    }
}

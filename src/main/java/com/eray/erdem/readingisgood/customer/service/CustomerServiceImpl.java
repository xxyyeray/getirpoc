package com.eray.erdem.readingisgood.customer.service;

import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.eray.erdem.readingisgood.customer.validator.EmailValidator;
import com.eray.erdem.readingisgood.customer.validator.PasswordMatchValidator;
import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;
import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.model.OrderResponse;
import com.eray.erdem.readingisgood.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final EmailValidator emailValidator;
    private final PasswordMatchValidator passwordMatchValidator;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private static final int PAGE_SIZE = 5;

    private final PasswordEncoder bcyrptPasswordencoder;

    @Override
    public CustomerCreateResponse persistCustomer(CustomerCreate customerCreate) {
        String email = customerCreate.getEmail();

        log.info("customer validating which email is  {}", email);
        emailValidator.validate(customerCreate);
        passwordMatchValidator.validate(customerCreate);
        log.info("customer validation passed  which email is  {}", email);
        log.info("customer creating which email is  {}", email);
        Customer customer = Customer.builder()
                .name(customerCreate.getName())
                .surname(customerCreate.getSurname())
                .password(bcyrptPasswordencoder.encode(customerCreate.getPassword()))
                .email(email)
                .build();

        Customer save = customerRepository.insert(customer);
        log.info("customer created which email is  {}", email);
        return new CustomerCreateResponse(save.getId());
    }

    @Override
    public CustomerOrderItem getOrdersOfCustomer(String id, int page) {

        if (page != 0)
            page -= 1;

        List<Order> orders = orderRepository.findAllByCustomer_Id(id, PageRequest.of(page, PAGE_SIZE));
        log.info("The orders of the customer  {} are being brought with page = {} and pageSize = {}", id, page, PAGE_SIZE);
        CustomerOrderItem customerOrderItem = new CustomerOrderItem();

        List<OrderResponse> orderList = new ArrayList<>();
        customerOrderItem.setOrders(orderList);
        customerOrderItem.setCustomerId(id);
        orders.forEach(e -> {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setItems(e.getItems());
            orderResponse.setOrderDate(e.getOrderDate());
            orderResponse.setOrderStatus(e.getOrderStatus());
            orderList.add(orderResponse);
        });

        log.info("The order of the customer {} received {} orders found", id, orderList.size());
        return customerOrderItem;

    }


}

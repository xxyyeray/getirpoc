package com.eray.erdem.readingisgood.customer.service;

import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.eray.erdem.readingisgood.customer.validator.EmailValidator;
import com.eray.erdem.readingisgood.customer.validator.PasswordMatchValidator;
import com.eray.erdem.readingisgood.order.model.Asd;
import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;
import com.eray.erdem.readingisgood.order.model.Order;
import com.eray.erdem.readingisgood.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public CustomerCreateResponse persistCustomer(CustomerCreate customerCreate) {
        emailValidator.validate(customerCreate);
        passwordMatchValidator.validate(customerCreate);
        String email = customerCreate.getEmail();
        log.info("customer creating which email is  {}", email);
        Customer customer = Customer.builder()
                .name(customerCreate.getName())
                .surname(customerCreate.getSurname())
                .password(customerCreate.getPassword())
                .email(email)
                .build();

        Customer save = customerRepository.save(customer);
        log.info("customer created which email is  {}", email);
        return new CustomerCreateResponse(save.getId());
    }

    @Override
    public CustomerOrderItem getOrdersOfCustomer(String id, int page) {
        if (page <= 0)
            page = 0;
        else
            page -= 1;

        List<Order> orders = orderRepository.findAllByCustomer_Id(id, PageRequest.of(page, PAGE_SIZE));

        CustomerOrderItem customerOrderItem = new CustomerOrderItem();

        List<Asd> orders1 = new ArrayList<>();
        customerOrderItem.setOrders(orders1);
        customerOrderItem.setCustomerId(id);
        orders.forEach(e -> {
            Asd asd = new Asd();
            asd.setItems(e.getItems());
            asd.setOrderDate(e.getOrderDate());
            asd.setOrderStatus(e.getOrderStatus());
            orders1.add(asd);
        });
        return customerOrderItem;

    }


}

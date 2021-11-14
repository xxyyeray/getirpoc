package com.eray.erdem.readingisgood.customer.service;

import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;
import com.eray.erdem.readingisgood.order.model.OrderInjection;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;

import java.util.List;

public interface CustomerService {

    CustomerCreateResponse persistCustomer(final CustomerCreate bookPersist);

    CustomerOrderItem getOrdersOfCustomer(String id, int page);

}

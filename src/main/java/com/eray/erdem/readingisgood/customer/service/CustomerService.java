package com.eray.erdem.readingisgood.customer.service;

import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.model.CustomerCreateResponse;
import com.eray.erdem.readingisgood.order.model.CustomerOrderItem;

public interface CustomerService {

    CustomerCreateResponse persistCustomer(final CustomerCreate bookPersist);

    CustomerOrderItem getOrdersOfCustomer(String id, int page);

}

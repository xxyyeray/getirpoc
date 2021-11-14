package com.eray.erdem.readingisgood.order.repository;

import com.eray.erdem.readingisgood.order.model.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllByCustomer_Id(String customerId, PageRequest pageRequest);

    List<Order> findAllByCustomer_Id(String customerId);

    List<Order> findAllByOrderDateBetween(Date startDate, Date endDate);

}

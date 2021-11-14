package com.eray.erdem.readingisgood.customer.repository;

import com.eray.erdem.readingisgood.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    boolean existsByEmail(String email);
 }

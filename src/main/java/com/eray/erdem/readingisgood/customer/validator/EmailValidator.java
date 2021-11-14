package com.eray.erdem.readingisgood.customer.validator;

import com.eray.erdem.readingisgood.customer.exception.RegisteredEmailException;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailValidator {

    private final CustomerRepository customerRepository;

    public void validate(CustomerCreate customer) {

        String email = customer.getEmail();
        if (customerRepository.existsByEmail(email)) {
            log.error("Registered email account {}", email);
            throw new RegisteredEmailException(email);
        }
    }
}
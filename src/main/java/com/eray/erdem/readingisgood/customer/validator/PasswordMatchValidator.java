package com.eray.erdem.readingisgood.customer.validator;

import com.eray.erdem.readingisgood.customer.exception.PasswordMatchException;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PasswordMatchValidator {
    public void validate(CustomerCreate customer) {

        String password = customer.getPassword(); //
        String confirmPassword = customer.getConfirmPassword();
        if (!password.equals(confirmPassword)) {
            log.error("password not matched password is {} and confirmPassword is {}", password, confirmPassword);
            throw new PasswordMatchException(password, confirmPassword);
        }
    }
}

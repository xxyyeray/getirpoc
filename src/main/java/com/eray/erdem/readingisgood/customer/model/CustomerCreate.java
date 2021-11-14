package com.eray.erdem.readingisgood.customer.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CustomerCreate {

    @Size(min = 3, max = 35, message = "set valid name between 3-35")
    @NotNull(message = "name can not be null")
    private String name;

    @Size(min = 3, max = 25, message = "surname must be between 3-25 character")
    @NotNull(message = "name can not be null")
    private String surname;

    @Email(message = "please enter a valid email address")
    @NotNull(message = "email can not be null")
    private String email;


    @Size(min = 6, max = 35, message = "set valid password between 3-35")
    @NotNull(message = "password can not be blank")
    private String password;


    @NotBlank(message = "confirmpassword can not be blank")
    private String confirmPassword;
}

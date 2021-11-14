package com.eray.erdem.readingisgood.customer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customer")
@Data
@Builder
public class Customer {

    @Id
    private String id;
    private String name;
    private String surname;
    private String email;
    @JsonIgnore
    private String password;


}


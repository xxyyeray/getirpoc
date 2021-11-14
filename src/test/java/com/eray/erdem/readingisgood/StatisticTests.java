package com.eray.erdem.readingisgood;

import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StatisticTests {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createBook() throws Exception {


        Customer password = Customer.builder()
                .name("musa yallah")
                .surname("erdem")
                .email("musayallah@gmail.com")
                .password("Hello world").build();

        Customer insert = customerRepository.insert(password);

        String id = insert.getId();

        this.mvc.perform(
                        get("/statistics/" + id))
                .andExpect(status().isOk())
                .andReturn();

    }


}

package com.eray.erdem.readingisgood;

import com.eray.erdem.readingisgood.book.model.Book;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.eray.erdem.readingisgood.order.model.OrderCreate;
import com.eray.erdem.readingisgood.order.model.OrderItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderTests {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mvc;


    @Autowired
    private BookRepository bookRepository;

    @Test
    void createOrder() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        Customer password = Customer.builder()
                .name("samet")
                .surname("erdem")
                .email("ahmetgns@gmail.com")
                .password("Hello world").build();

        Customer insert = customerRepository.insert(password);

        String id = insert.getId();


        Book build = Book.builder()
                .author("Josh Long ")
                .isbn("978-3836514484")
                .price(12.0)
                .stock(123)
                .title("Reactive Spring ")
                .build();

        bookRepository.save(build);


        OrderCreate orderCreate = new OrderCreate();
        orderCreate.setCustomerNumber(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setIsbn("978-3836514484");
        orderItem.setAmount(3);
        orderCreate.setBooks(Collections.singletonList(orderItem));

        String content = objectMapper.writeValueAsString(orderCreate);

        this.mvc.perform(
                        post("/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content))
                .andExpect(status().isCreated())
                .andReturn();

    }
}

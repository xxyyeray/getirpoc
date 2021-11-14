package com.eray.erdem.readingisgood;

import com.eray.erdem.readingisgood.customer.model.Customer;
import com.eray.erdem.readingisgood.customer.model.CustomerCreate;
import com.eray.erdem.readingisgood.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void createCustomer() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		CustomerCreate customerRequest = CustomerCreate.builder()
				.name("samet")
				.surname("erdem")
				.email("sameterayerdem1235r@gmail.com")
				.password("helloworld")
				.confirmPassword("helloworld")
				.build();

		String customer = objectMapper.writeValueAsString(customerRequest);

		this.mvc.perform(
						post("/customers")
								.contentType(MediaType.APPLICATION_JSON)
								.content(customer))
				.andExpect(status().isCreated())
				.andReturn();


	}

	@Test
	void getAllOrdersOfCustomer() throws Exception {

		Customer password = Customer.builder()
				.name("samet")
				.surname("erdem")
				.email("ahmetgns@gmail.com")
				.password("Hello world").build();

		Customer insert = customerRepository.insert(password);

		String id = insert.getId();


		this.mvc.perform(
						get("/customers/" + id + "/orders/1"))
				.andExpect(status().isOk())
				.andReturn();

	}

}

package com.eray.erdem.readingisgood;

import com.eray.erdem.readingisgood.book.model.Book;
import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookUpdate;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookTests {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private BookRepository bookRepository;

    @Test
    void createBook() throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();

        BookCreate build = BookCreate.builder()
                .author("Josh    Long")
                .isbn("978-1-56619-909-4")
                .title("Reactive Spring")
                .stock(1000)
                .price(15.0)
                .build();

        String book = objectMapper.writeValueAsString(build);

        this.mvc.perform(
                        post("/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(book))
                .andExpect(status().isCreated())
                .andReturn();

    }



    @Test
    void updateBook() throws Exception {


        Book build = Book.builder()
                .author("Josh Long ")
                .isbn("978-3-16-148410-0")
                .price(12.0)
                .stock(123)
                .title("Reactive Spring ")
                .build();

        bookRepository.save(build);

        ObjectMapper objectMapper = new ObjectMapper();

        BookUpdate bookUpdate = new BookUpdate();
        bookUpdate.setIsbn("978-3-16-148410-0");
        bookUpdate.setStock(512);

        String s = objectMapper.writeValueAsString(bookUpdate);

        this.mvc.perform(
                        patch("/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(s))
                .andExpect(status().isOk())
                .andReturn();

    }

}

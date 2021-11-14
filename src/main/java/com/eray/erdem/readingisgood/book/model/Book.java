package com.eray.erdem.readingisgood.book.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
@Data
@Builder
public class Book {

    @Id
    private String id;
    private String isbn;
    private String title;
    private String author;
    private int stock;
    private Double price;
}


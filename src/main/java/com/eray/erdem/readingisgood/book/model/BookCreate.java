package com.eray.erdem.readingisgood.book.model;

import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookCreate {

    @ISBN(message = "set valid isbn format")
    @NotNull(message = "name can not be null")
    private String isbn;

    @Size(min = 3, max = 25, message = "title must be between 3-25 character")
    @NotNull(message = "title can not be null")
    private String title;

    @Size(min = 10, max = 50, message = "author must be between 10-50 character")
    @NotNull(message = "author can not be null")
    private String author;


    @Min(value = 0, message = "stock size must be bigger than -1")
    @NotNull(message = "stock can not be null")
    private Integer stock;

    @Min(value = 5, message = "price must be bigger than 5")
    @NotNull(message = "price can not be null")
    private Double price;

}

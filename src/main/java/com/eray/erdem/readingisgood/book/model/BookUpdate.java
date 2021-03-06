package com.eray.erdem.readingisgood.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdate {

    @ISBN(message = "set valid isbn format")
    @NotNull(message = "name can not be null")
    private String isbn;

    @Min(value = 0, message = "stock size must be bigger than -1")
    @NotNull(message = "stock can not be null")
    private Integer stock;

}

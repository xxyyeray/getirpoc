package com.eray.erdem.readingisgood.book.controller;


import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookUpdate;
import com.eray.erdem.readingisgood.book.service.BookService;
import com.eray.erdem.readingisgood.book.validator.IsbnValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "books")
public class BookController {

    private final IsbnValidator isbnValidator;
    private final BookService bookService;

    @InitBinder(value = "bookPersist")
    final protected void bindValidator(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(isbnValidator);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void persistBook(@Valid @RequestBody BookCreate bookPersist) {
        bookService.persistBook(bookPersist);
    }


    @PatchMapping
    @ResponseStatus(NO_CONTENT)
    public void updateStockSize(@Valid @RequestBody BookUpdate bookUpdate) {
        bookService.updateStockSizeOfBook(bookUpdate);
    }
}

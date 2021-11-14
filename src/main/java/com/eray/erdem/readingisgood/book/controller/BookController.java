package com.eray.erdem.readingisgood.book.controller;


import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookCreated;
import com.eray.erdem.readingisgood.book.model.BookUpdate;
import com.eray.erdem.readingisgood.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "books")
public class BookController {


    private final BookService bookService;

    @PostMapping
    @ResponseStatus(CREATED)
    public BookCreated persistBook(@Valid @RequestBody BookCreate bookPersist) {
        return bookService.persistBook(bookPersist);
    }


    @PatchMapping
    @ResponseStatus(OK)
    public BookUpdate updateStockSize(@Valid @RequestBody BookUpdate bookUpdate) {
        return bookService.updateStockSize(bookUpdate);
    }
}

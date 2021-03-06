package com.eray.erdem.readingisgood.book.service;


import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookCreated;
import com.eray.erdem.readingisgood.book.model.BookUpdate;

public interface BookService {

    public BookCreated persistBook(BookCreate book);

    public BookUpdate updateStockSize(BookUpdate book);
}

package com.eray.erdem.readingisgood.book.service;


import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookUpdate;

public interface BookService {

    public void persistBook( BookCreate book);

    public void updateStockSizeOfBook( BookUpdate book);
}

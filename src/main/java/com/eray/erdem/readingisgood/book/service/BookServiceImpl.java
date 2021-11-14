package com.eray.erdem.readingisgood.book.service;

import com.eray.erdem.readingisgood.book.exception.BookNotFoundException;
import com.eray.erdem.readingisgood.book.model.Book;
import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookCreated;
import com.eray.erdem.readingisgood.book.model.BookUpdate;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import com.eray.erdem.readingisgood.book.validator.IsbnValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final IsbnValidator isbnValidator;

    @Override
    public BookCreated persistBook(BookCreate bookDto) {


        String isbn = bookDto.getIsbn();
        isbnValidator.validate(isbn);
        log.info("Book  creating which isbn is  {}", isbn);

        Book book = Book.builder()
                .isbn(isbn)
                .stock(bookDto.getStock())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .price(bookDto.getPrice())
                .build();

        Book save = bookRepository.insert(book);


        log.info("Book created which isbn is  {}", isbn);
        return new BookCreated(save.getId());
    }

    @Override
    public BookUpdate updateStockSize(BookUpdate bookUpdate) {
        Optional<Book> book = bookRepository.findByIsbn(bookUpdate.getIsbn());

        book.ifPresentOrElse(e -> {
            String isbn = e.getIsbn();
            log.info("Book is found . stock is updating which isbn is {}", isbn);
            e.setStock(bookUpdate.getStock());
            bookRepository.save(e);
            log.info("Stock  updated which isbn is {}", isbn);
        }, () -> {
            throw new BookNotFoundException(bookUpdate.getIsbn());
        });

        return bookUpdate;
    }
}

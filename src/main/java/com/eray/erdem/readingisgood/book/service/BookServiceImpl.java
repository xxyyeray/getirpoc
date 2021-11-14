package com.eray.erdem.readingisgood.book.service;

import com.eray.erdem.readingisgood.book.exception.BookNotFoundException;
import com.eray.erdem.readingisgood.book.model.Book;
import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.model.BookUpdate;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void persistBook(BookCreate bookDto) {

        String isbn = bookDto.getIsbn();
        log.info("Book  creating which isbn is  {}", isbn);

        Book book = Book.builder()
                .isbn(isbn)
                .stock(bookDto.getStock())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .price(bookDto.getPrice())
                .build();

        bookRepository.save(book);
        log.info("Book created which isbn is  {}", isbn);
    }

    @Override
    @Transactional
    public void updateStockSizeOfBook(BookUpdate bookUpdate) {
        Optional<Book> book = bookRepository.findByIsbn(bookUpdate.getIsbn());

        book.ifPresentOrElse(e -> {
            e.setStock(bookUpdate.getStock());
            bookRepository.save(e);
        }, () -> {
            throw new BookNotFoundException("The book belonging to the entered isbn could not be found .");
        });


    }
}

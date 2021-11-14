package com.eray.erdem.readingisgood.book.validator;

import com.eray.erdem.readingisgood.book.exception.RegisteredBookException;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class IsbnValidator {

    private final BookRepository bookRepository;


    public void validate(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            log.error("Registered book {}", isbn);
            throw new RegisteredBookException(isbn);
        }
    }
}

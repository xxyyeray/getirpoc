package com.eray.erdem.readingisgood.book.validator;

import com.eray.erdem.readingisgood.book.model.BookCreate;
import com.eray.erdem.readingisgood.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
@Slf4j
public class IsbnValidator implements Validator {

    private final BookRepository bookRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return BookCreate.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookCreate book = (BookCreate) target;
        String isbn = book.getIsbn();
        if (bookRepository.existsByIsbn(isbn)) {
            log.error("Registered book {}", isbn);
            errors.rejectValue("email", null, "Registered book");

        }
    }
}

package com.eray.erdem.readingisgood.book.repository;

import com.eray.erdem.readingisgood.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    boolean existsByIsbn(String isbn);

    Optional<Book> findByIsbn(String isbn);
}

package com.me.polarbookshop.catalogservice.domain;


import java.util.Optional;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
public interface BookRepository {

    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbc(String isbn);

    Book save(Book book);

    void deleteById(String isbn);
}

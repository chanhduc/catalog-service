package com.me.polarbookshop.catalogservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    public InMemoryBookRepository() {
        initData();
    }

    private static void initData() {
        books.put("978-0321356680", new Book("978-0321356680", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 30.00));
        books.put("978-0981531649", new Book("978-0981531649", "Test Driven Development: By Example", "Kent Beck", 25.00));
        books.put("978-0132350884", new Book("978-0132350884", "The Clean Coder: A Code of Conduct for Professional Programmers", "Robert C. Martin", 20.00));
    }

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    @Override
    public boolean existsByIsbc(String isbn) {
        return books.containsKey(isbn);
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteById(String isbn) {
        books.remove(isbn);
    }
}

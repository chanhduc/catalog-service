package com.me.polarbookshop.catalogservice.demo;

import com.me.polarbookshop.catalogservice.domain.Book;
import com.me.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Chanh-Duc Ngo
 * @created-date 26/07/2024
 */
@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        // Add test data to the book repository
        var book1 = Book.of("1234567890", "Title 1", "Author 1", 9.99);
        var book2 = Book.of("1234567891", "Title 2", "Author 2", 8.99);
        var book3 = Book.of("1234567892", "Title 3", "Author 3", 7.99);
        var book4 = Book.of("1234567893", "Title 4", "Author 4", 6.99);
        var book5 = Book.of("1234567894", "Title 5", "Author 5", 5.99);

        bookRepository.saveAll(
                List.of(book1, book2, book3, book4, book5)
        );
    }
}

package com.me.polarbookshop.catalogservice.domain;

import com.me.polarbookshop.catalogservice.domain.exception.BookAlreadyExistsException;
import com.me.polarbookshop.catalogservice.domain.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) throws BookNotFoundException {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) throws BookAlreadyExistsException {
       if (bookRepository.existsByIsbn(book.isbn())) {
           throw new BookAlreadyExistsException(book.isbn());
       }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book) throws BookNotFoundException {
        return bookRepository.findByIsbn(isbn)
                .map(existingBook -> {
                    var updateBook = new Book(
                            existingBook.id(),
                            existingBook.version(),
                            existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price(),
                            existingBook.createdDate(),
                            existingBook.lastModifiedDate()
                    );
                    return bookRepository.save(updateBook);
                })
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }
}

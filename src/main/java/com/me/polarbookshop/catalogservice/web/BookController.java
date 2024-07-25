package com.me.polarbookshop.catalogservice.web;

import com.me.polarbookshop.catalogservice.domain.Book;
import com.me.polarbookshop.catalogservice.domain.BookService;
import com.me.polarbookshop.catalogservice.domain.exception.BookAlreadyExistsException;
import com.me.polarbookshop.catalogservice.domain.exception.BookNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> viewBookList() {
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book viewBookDetails(@PathVariable String isbn) throws BookNotFoundException {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBookToCatalog(@Valid @RequestBody Book book) throws BookAlreadyExistsException {
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBookFromCatalog(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book editBookDetails(@PathVariable String isbn, @Valid @RequestBody Book book) throws BookNotFoundException {
        return bookService.editBookDetails(isbn, book);
    }
}

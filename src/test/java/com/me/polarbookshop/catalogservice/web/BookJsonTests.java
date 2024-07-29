package com.me.polarbookshop.catalogservice.web;

import com.me.polarbookshop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chanh-Duc Ngo
 * @created-date 25/07/2024
 */
@JsonTest
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws IOException {
        Book book = Book.of("1234567890", "Title", "Author", 9.99);

        var jsonContent = json.write(book);
        assertThat(jsonContent)
                .extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());
        assertThat(jsonContent)
                .extractingJsonPathStringValue("@.title").isEqualTo(book.title());
        assertThat(jsonContent)
                .extractingJsonPathStringValue("@.author").isEqualTo(book.author());
        assertThat(jsonContent)
                .extractingJsonPathNumberValue("@.price").isEqualTo(book.price());
    }

    @Test
    void testDeserialize() throws IOException {
        String content = """
                {
                    "isbn": "1234567890",
                    "title": "Title",
                    "author": "Author",
                    "price": 9.99
                }
                """;

        var book = json.parse(content).getObject();
        assertThat(book.isbn()).isEqualTo("1234567890");
        assertThat(book.title()).isEqualTo("Title");
        assertThat(book.author()).isEqualTo("Author");
        assertThat(book.price()).isEqualTo(9.99);
    }
}

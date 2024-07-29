package com.me.polarbookshop.catalogservice.domain;

import com.me.polarbookshop.catalogservice.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chanh-Duc Ngo
 * @created-date 29/07/2024
 */
@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("integration")
public class BookRepositoryJdbcTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findBookByIsbnWhenExisiting() {
        // Given
        String bookisbn = "1234567890";
        var book = Book.of(bookisbn, "Title 1", "Author 1", 9.99);
        jdbcAggregateTemplate.insert(book);

        // When
        var foundBook = bookRepository.findByIsbn("1234567890");

        // Then
        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().isbn()).isEqualTo("1234567890");
    }
}

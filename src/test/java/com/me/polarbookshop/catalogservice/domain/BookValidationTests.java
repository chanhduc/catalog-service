package com.me.polarbookshop.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author Chanh-Duc Ngo
 * @created-date 25/07/2024
 */
public class BookValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrect_thenValidationSucceeds() {
        Book book = Book.of("1234567890", "Title", "Author", 9.99);
        Set<ConstraintViolation<Book>> violationSet = validator.validate(book);
        assertThat(violationSet).isEmpty();
    }

    @Test
    void whenIsbnDefinedButIncorrect_thenValidationFails() {
        Book book = Book.of("123456789", "Title", "Author", 9.99);
        Set<ConstraintViolation<Book>> violationSet = validator.validate(book);
        assertThat(violationSet).hasSize(1);
        assertThat(violationSet.iterator().next().getMessage()).isEqualTo("The book ISBC must be a valid ISBN-10 or ISBN-13.");
    }

}

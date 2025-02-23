package com.me.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.*;

import java.time.Instant;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
public record Book(
        @Id
        Long id,

        @Version
        int version,

        @NotBlank(message = "The book ISBC must not be blank.")
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The book ISBC must be a valid ISBN-10 or ISBN-13.")
        String isbn,

        @NotBlank(message = "The book title must not be blank.")
                @Size(max = 255, message = "The book title must be less than 256 characters.")
        String title,

        @NotBlank(message = "The book author must not be blank.")
        @Size(max= 255, message = "The book author must be less than 256 characters.")
        String author,

        @NotNull(message = "The book price must not be null.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,

        @Size(max = 255, message = "The book publisher must be less than 256 characters.")
        String publisher,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate
) {
        public static Book of(String isbn, String title, String author, double price) {
                return new Book(null,0, isbn, title, author, price,null,null,null);
        }
}

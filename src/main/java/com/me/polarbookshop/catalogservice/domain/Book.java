package com.me.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * @author Chanh-Duc Ngo
 * @created-date 24/07/2024
 */
public record Book(

        @NotBlank(message = "The book ISBC must not be blank.")
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The book ISBC must be a valid ISBN-10 or ISBN-13.")
        String isbn,

        @NotBlank(message = "The book title must not be blank.")
        String title,

        @NotBlank(message = "The book author must not be blank.")
        String author,

        @NotNull(message = "The book price must not be null.")
        @Positive(message = "The book price must be greater than zero.")
        Double price
) {
}

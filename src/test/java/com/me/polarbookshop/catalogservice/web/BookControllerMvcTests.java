package com.me.polarbookshop.catalogservice.web;

import com.me.polarbookshop.catalogservice.domain.BookService;
import com.me.polarbookshop.catalogservice.domain.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Chanh-Duc Ngo
 * @created-date 25/07/2024
 */
@WebMvcTest
public class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNotExisiting_thenReturn404() throws Exception {
        given(bookService.viewBookDetails("1234567890"))
                .willThrow(new BookNotFoundException("1234567890"));


        mockMvc.perform(get("/books/1234567890"))
                .andExpect(status().isNotFound());
    }


}

package com.me.polarbookshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chanh-Duc Ngo
 * @created-date 23/07/2024
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String greeting() {
        return "Welcome to Polar Bookshop";
    }
}

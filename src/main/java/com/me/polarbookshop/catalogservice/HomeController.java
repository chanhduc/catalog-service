package com.me.polarbookshop.catalogservice;

import com.me.polarbookshop.catalogservice.config.PolarProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chanh-Duc Ngo
 * @created-date 23/07/2024
 */
@RestController
public class HomeController {

    private final PolarProperties polarProperties;

    public HomeController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String greeting() {
        return polarProperties.getWelcomeMessage();
    }
}

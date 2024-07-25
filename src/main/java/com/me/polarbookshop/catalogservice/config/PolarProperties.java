package com.me.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Chanh-Duc Ngo
 * @created-date 25/07/2024
 */
@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    /**
     * A message to welcome users.
     */
    private String welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}

package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 4 — Starts the Country REST service.
 * Available endpoints after startup:
 *   http://localhost:8083/country
 *   http://localhost:8083/countries
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Country REST service starting up");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Country REST service ready on port 8083");
    }
}

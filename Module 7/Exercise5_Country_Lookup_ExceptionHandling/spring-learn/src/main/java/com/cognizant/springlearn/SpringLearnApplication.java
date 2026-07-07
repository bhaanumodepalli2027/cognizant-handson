package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 5 — Country lookup REST service with exception handling.
 * Try these after startup:
 *   curl http://localhost:8083/countries
 *   curl http://localhost:8083/countries/in
 *   curl http://localhost:8083/countries/XX  (returns 404)
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Country lookup service starting");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Service ready — port 8083");
    }
}

package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 3 — Bootstraps the Hello World REST application.
 * Once started, the embedded server listens on port 8083.
 * Navigate to http://localhost:8083/hello to test the endpoint.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Launching Hello World REST application");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Server is up — try GET http://localhost:8083/hello");
    }
}

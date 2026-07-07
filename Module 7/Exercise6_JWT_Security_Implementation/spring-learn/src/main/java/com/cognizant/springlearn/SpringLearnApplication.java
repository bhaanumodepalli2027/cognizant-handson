package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 6 — JWT-secured Spring Boot application.
 *
 * Workflow:
 *  Step 1 - Obtain token  : curl -s -u user:pwd http://localhost:8083/authenticate
 *  Step 2 - Access data   : curl -s -H "Authorization: Bearer <token>"
 *                               http://localhost:8083/countries
 *  Step 3 - Tamper test   : modify the token and expect HTTP 403/401
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("JWT-secured application starting");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Application ready — authenticate at /authenticate");
    }
}

package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the spring-learn application.
 *
 * Key points demonstrated:
 *  - @SpringBootApplication combines @Configuration, @EnableAutoConfiguration
 *    and @ComponentScan into a single convenience annotation.
 *  - SpringApplication.run() bootstraps the application and starts the
 *    embedded Tomcat server.
 *  - SLF4J logger captures application lifecycle events without
 *    using System.out.println().
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Application bootstrap initiated");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Application started successfully on port 8083");
    }
}

package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Exercise 2 — Loads Country beans from a Spring XML configuration file.
 *
 * Three concepts are demonstrated:
 *   1. Reading a single bean from XML using ClassPathXmlApplicationContext.
 *   2. Singleton scope  — two getBean() calls on the same id return
 *      the identical object reference (country == anotherCountry is true).
 *   3. List bean       — an ArrayList of Country references defined in XML
 *      and retrieved as a typed list.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();
        displayCountries();
        LOGGER.info("END");
    }

    /**
     * Demonstrates singleton scope:
     * Both 'first' and 'second' point to the same Country instance
     * because the default Spring bean scope is singleton.
     */
    public static void displayCountry() {
        LOGGER.info("START");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");

        Country first  = ctx.getBean("country", Country.class);
        Country second = ctx.getBean("country", Country.class);

        LOGGER.debug("first  -> {}", first);
        LOGGER.debug("second -> {}", second);
        LOGGER.debug("Same instance? {}", (first == second));
        LOGGER.info("END");
    }

    /**
     * Reads the countryList ArrayList bean from XML and logs each entry.
     */
    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");

        List<Country> list = (List<Country>) ctx.getBean("countryList");
        for (Country c : list) {
            LOGGER.debug("Entry -> {}", c);
        }
        LOGGER.info("END");
    }
}

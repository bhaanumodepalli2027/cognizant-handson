package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller providing country data endpoints.
 *
 * Two separate URL mappings — NO ambiguity:
 *   GET /country    -> single country (India) as JSON object
 *   GET /countries  -> all four countries as JSON array
 *
 * Jackson automatically converts the returned Country / List objects
 * into JSON in the HTTP response body.
 *
 * Sample responses:
 *   GET /country   -> {"code":"IN","name":"India"}
 *   GET /countries -> [{"code":"IN","name":"India"}, ...]
 */
@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    /**
     * Returns India country details loaded from the Spring XML config.
     * URL : GET /country
     */
    @GetMapping("/country")
    public Country fetchIndiaDetails() {
        LOGGER.info("START fetchIndiaDetails");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        Country result = ctx.getBean("singleCountry", Country.class);
        LOGGER.debug("Returning -> {}", result);
        LOGGER.info("END fetchIndiaDetails");
        return result;
    }

    /**
     * Returns all four countries loaded from the Spring XML config.
     * URL : GET /countries
     */
    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> fetchAllCountries() {
        LOGGER.info("START fetchAllCountries");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) ctx.getBean("countryList");
        LOGGER.debug("Total countries returned -> {}", list.size());
        LOGGER.info("END fetchAllCountries");
        return list;
    }
}

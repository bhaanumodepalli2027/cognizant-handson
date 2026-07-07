package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Handles all country-related HTTP requests.
 *
 * URL design follows RESTful naming conventions:
 *   GET /countries          -> collection  (all countries)
 *   GET /countries/{code}   -> single item (specific country)
 *
 * Note: /country (singular) is kept as a separate convenience endpoint
 * that always returns India without any path variable.
 *
 * The @GetMapping annotations ensure Spring maps each URL to exactly
 * one method — there is NO ambiguous mapping in this controller.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * GET /countries — returns the full list of supported countries.
     */
    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) ctx.getBean("countryList");
        LOGGER.debug("Returning {} countries", list.size());
        LOGGER.info("END");
        return list;
    }

    /**
     * GET /countries/{code} — returns the country matching the given ISO code.
     * The lookup is case-insensitive: /countries/in == /countries/IN.
     * Returns HTTP 404 if the code is not found.
     */
    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code)
            throws CountryNotFoundException {
        LOGGER.info("START");
        Country result = countryService.findByCode(code);
        LOGGER.debug("Resolved {} -> {}", code, result);
        LOGGER.info("END");
        return result;
    }
}

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
 * Protected resource endpoint.
 *
 * This controller is only reachable when the request carries a valid JWT
 * in the Authorization header (Bearer scheme). Spring Security's
 * JwtAuthorizationFilter validates the token before this method executes.
 *
 * Usage after obtaining a token:
 *   curl -s -H "Authorization: Bearer <token>" http://localhost:8083/countries
 */
@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public List<Country> listCountries() {
        LOGGER.info("START");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> result = (List<Country>) ctx.getBean("countryList");
        LOGGER.debug("Returning {} countries", result.size());
        LOGGER.info("END");
        return result;
    }
}

package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Business layer responsible for country lookup operations.
 *
 * Data source: country.xml loaded via ClassPathXmlApplicationContext.
 * The lookup is case-insensitive so that /countries/in and /countries/IN
 * both resolve to the India entry.
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    /**
     * Searches the country list for an entry whose ISO code matches
     * the supplied value (comparison is case-insensitive).
     *
     * @param code  the ISO country code received from the URL path variable
     * @return      the matching Country object
     * @throws CountryNotFoundException if no matching code is found
     */
    @SuppressWarnings("unchecked")
    public Country findByCode(String code) throws CountryNotFoundException {
        LOGGER.info("START");
        LOGGER.debug("Searching for country with code -> {}", code);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) ctx.getBean("countryList");

        Optional<Country> match = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (match.isEmpty()) {
            LOGGER.warn("No country found for code -> {}", code);
            throw new CountryNotFoundException(
                    "No country found matching code: " + code.toUpperCase());
        }

        LOGGER.debug("Match found -> {}", match.get());
        LOGGER.info("END");
        return match.get();
    }
}

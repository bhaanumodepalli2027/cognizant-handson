package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a booking-supported country with an ISO code and full name.
 *
 * Spring uses the no-arg constructor when instantiating this bean,
 * then calls each setter to inject values defined in country.xml.
 * Debug logs are placed inside every constructor and accessor so that
 * the call sequence is visible in the console during runtime.
 */
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    public Country() {
        LOGGER.debug("Country object created by Spring IoC container");
    }

    public String getCode() {
        LOGGER.debug("getCode invoked, returning -> {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("setCode invoked with value -> {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("getName invoked, returning -> {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("setName invoked with value -> {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}

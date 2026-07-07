package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Raised by CountryService when the requested ISO code does not match
 * any entry in the country list.
 *
 * @ResponseStatus maps this exception directly to HTTP 404 Not Found,
 * so Spring MVC returns the correct status code and reason phrase
 * without any additional exception handler code.
 *
 * Sample error response:
 * {
 *   "status": 404,
 *   "error": "Not Found",
 *   "message": "Country not found",
 *   "path": "/countries/az"
 * }
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CountryNotFoundException(String message) {
        super(message);
    }
}

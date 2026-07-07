package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposes a single GET endpoint that returns a plain-text greeting.
 *
 * How it works:
 *   @RestController  = @Controller + @ResponseBody, so the return value
 *   is written directly to the HTTP response body instead of being
 *   resolved as a view name.
 *
 * Endpoint details:
 *   Method   : GET
 *   URL      : /hello
 *   Response : Hello World!!
 *
 * Test with browser : http://localhost:8083/hello
 * Test with curl    : curl http://localhost:8083/hello
 * Test with Postman : GET http://localhost:8083/hello
 */
@RestController
public class HelloController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("START");
        String greeting = "Hello World!!";
        LOGGER.debug("Returning greeting -> {}", greeting);
        LOGGER.info("END");
        return greeting;
    }
}

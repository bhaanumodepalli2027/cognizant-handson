package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Verifies that the Spring application context loads without errors.
 * If any bean wiring or configuration is broken, this test will fail fast.
 */
@SpringBootTest
class SpringLearnApplicationTests {

    @Test
    void applicationContextLoadsWithoutErrors() {
        // Passes as long as the application context starts cleanly.
    }
}

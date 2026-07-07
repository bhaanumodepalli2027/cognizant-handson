package com.cognizant;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreeting() {
        App app = new App();
        assertEquals("Hello JUnit", app.greet());
    }
}

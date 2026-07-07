package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Validates that country beans are correctly loaded from country.xml
 * and that singleton scope behaves as expected.
 */
@SpringBootTest
class SpringLearnApplicationTests {

    @Test
    void contextLoadsSuccessfully() {
        // Spring context must start without any wiring errors
    }

    @Test
    void singletonScopeReturnsSameInstance() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        Country a = ctx.getBean("country", Country.class);
        Country b = ctx.getBean("country", Country.class);
        assertSame(a, b, "Default scope is singleton — both references must be identical");
    }

    @Test
    @SuppressWarnings("unchecked")
    void countryListContainsFourEntries() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (List<Country>) ctx.getBean("countryList");
        assertEquals(4, list.size(), "XML must define exactly four countries");
    }

    @Test
    void indiaCountryBeanHasCorrectValues() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("country.xml");
        Country india = ctx.getBean("country", Country.class);
        assertEquals("IN",    india.getCode());
        assertEquals("India", india.getName());
    }
}

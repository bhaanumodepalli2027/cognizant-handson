package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * End-to-end tests for country lookup endpoints.
 * Covers success paths, case-insensitive matching, and 404 error handling.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void countryControllerIsInjected() {
        assertNotNull(countryController);
    }

    @Test
    void getAllCountriesReturnsFullList() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void getByCodeLowercaseReturnsIndia() throws Exception {
        mockMvc.perform(get("/countries/in"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("IN"))
               .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void getByCodeUppercaseReturnsGermany() throws Exception {
        mockMvc.perform(get("/countries/DE"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("DE"))
               .andExpect(jsonPath("$.name").value("Germany"));
    }

    @Test
    void getByInvalidCodeReturns404() throws Exception {
        mockMvc.perform(get("/countries/XX"))
               .andExpect(status().isNotFound());
    }
}

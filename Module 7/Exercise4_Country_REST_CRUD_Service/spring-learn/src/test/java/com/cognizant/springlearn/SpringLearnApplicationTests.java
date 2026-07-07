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
 * Validates both country endpoints using MockMvc.
 * No real HTTP server is started — requests are processed in-process.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void controllerBeanIsAvailable() {
        assertNotNull(countryController);
    }

    @Test
    void getSingleCountryReturnsIndia() throws Exception {
        mockMvc.perform(get("/country"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.code").value("IN"))
               .andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void getAllCountriesReturnsFourEntries() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void allCountriesListContainsIndia() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].code").value("IN"))
               .andExpect(jsonPath("$[0].name").value("India"));
    }

    @Test
    void allCountriesListContainsUnitedStates() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[1].code").value("US"));
    }
}

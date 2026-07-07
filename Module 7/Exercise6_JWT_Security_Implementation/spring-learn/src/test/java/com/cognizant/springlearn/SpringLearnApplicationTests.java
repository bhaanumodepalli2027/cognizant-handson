package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.AuthenticationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for JWT authentication and protected endpoints.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private AuthenticationController authController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void authenticationControllerBeanPresent() {
        assertNotNull(authController);
    }

    @Test
    void authenticateWithValidCredentialsReturnsToken() throws Exception {
        String creds = Base64.getEncoder().encodeToString("user:pwd".getBytes());
        mockMvc.perform(get("/authenticate")
                       .header("Authorization", "Basic " + creds))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.token").isNotEmpty());
    }

    @Test
    void countriesEndpointWithoutTokenReturnsUnauthorized() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void countriesEndpointWithMockUserReturnsData() throws Exception {
        mockMvc.perform(get("/countries"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(4));
    }
}

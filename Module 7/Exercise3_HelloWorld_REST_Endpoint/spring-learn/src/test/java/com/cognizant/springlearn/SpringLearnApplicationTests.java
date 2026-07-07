package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for the Hello World REST endpoint.
 * MockMvc simulates an HTTP client without starting a real server.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private HelloController helloController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloControllerBeanIsPresent() {
        assertNotNull(helloController, "HelloController must be wired by Spring");
    }

    @Test
    void getHelloReturnsOkStatus() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk());
    }

    @Test
    void getHelloReturnsExpectedGreeting() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello World!!"));
    }
}

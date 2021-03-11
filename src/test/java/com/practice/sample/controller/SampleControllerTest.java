package com.practice.sample.controller;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@WebMvcTest //instead of above this can be used
class SampleControllerTest {

    @LocalServerPort
    private int port; // not needed if using MockMvc

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Autowired
    private TestRestTemplate restTemplate; //Not needed if using MockMvc

    @Test
    public void greetingsTest() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:" + port + "/sample/greetings", String.class)).contains("HI There!");
    }

    @Test
    public void greetingTest_usingMockMVC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sample/greetings")).andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("HI There!")));
    }
}
package com.stackroute.appservice.controller;

import com.stackroute.appservice.config.JwtTokenGeneratorTestUtil;
import com.stackroute.appservice.util.TestUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ServiceControllerTestIT {
    private MockMvc mockMvc;
    private TestUser user;
    @Autowired
    ServiceController serviceController;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(serviceController).build();
        user = new TestUser("meghna@email.com","meghna@123");
    }
    @Test
    void getSensitivbeData() throws Exception{
        mockMvc.perform(get("/api/v1/data")
                .header("Authorization", "Bearer " + new JwtTokenGeneratorTestUtil().generateToken(user)))
                .andExpect(status().isOk())
                .andExpect(content().string("You have been validated..."));



    }
}
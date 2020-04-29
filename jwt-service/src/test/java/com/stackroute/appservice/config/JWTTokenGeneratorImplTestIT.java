package com.stackroute.appservice.config;

import com.stackroute.appservice.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTTokenGeneratorImplTestIT {
    private User user;
    @Autowired
    private JWTTokenGeneratorImpl tokenGenerator;
    private Map<String, String> tokenMap;
    @BeforeEach
    public void setup(){
     user = new User("Andy","andy@email.com");
     tokenMap= new HashMap<>();
    }

    @Test
    void givenAUserThenCallToGenerateTokenShouldRetuturnNotNull() {
        /*Act*/
        tokenMap=tokenGenerator.generateToken(user);
        /*Assert*/
        assertNotNull(tokenMap);
    }
    @Test
    void givenAUserShouldReturnExpectedKeysInMap() {
        /*ACt*/
        tokenMap=tokenGenerator.generateToken(user);
        /*Assert*/
        assertNotNull(tokenMap.containsKey("token"));
        assertNotNull(tokenMap.containsKey("message"));
    }
    @Test
    void givenAUserShouldReturnExpectedTokenInMap() {
        /*ACt*/
        tokenMap=tokenGenerator.generateToken(user);
        /*Assert*/
        System.out.println(tokenMap.get("token"));
        assertThat(tokenMap.get("token").length()).isGreaterThan(20);
    }
    @Test
    void givenAUserShouldReturnExpectedClaimInMap() {
        /*ACt*/
        tokenMap=tokenGenerator.generateToken(user);
        /*Assert*/
        assertThat(tokenMap.get("message")).isEqualTo("Login Successful");
    }
}
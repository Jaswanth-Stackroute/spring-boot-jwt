package com.stackroute.appservice.config;

import java.util.Map;

import com.stackroute.appservice.domain.User;

public interface JWTTokenGenerator {
	public Map<String, String> generateToken(User user);
}

package com.stackroute.appservice.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.stackroute.appservice.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTTokenGeneratorImpl implements JWTTokenGenerator {


	@Value("${jwt.secret}")
	private String secret;
	@Override
	public Map<String, String> generateToken(User user) {
		String jwtToken = "";
		jwtToken = Jwts.builder().setSubject(user.getId()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, secret).compact();
		Map<String, String> jwtTokenMap = new HashMap<>();
		jwtTokenMap.put("token", jwtToken);
		jwtTokenMap.put("message", "Login Successful");
		return jwtTokenMap;
	}
}

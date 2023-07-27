package com.example.auth.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.auth.entities.User;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	//método que gera um token JWT
	public String generatedToken(User user) {
		
		try {
			
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("auth-api")
					.withSubject(user.getLogin())
					.withExpiresAt(generatedExpirationDate())
					.sign(algorithm);
			
			return token;
		}
		catch(JWTCreationException exception) {
			
			throw new RuntimeException("Error while generating token", exception);
		}
	}
	
	//método que valida um token JWT
	public String validateToken(String token) {
		
		try {
			
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build()
					.verify(token)
					.getSubject();
		}
		catch (JWTVerificationException exception) {
			
			return "";
		}
	}
	
	//método que gera um instante após 2h
	private Instant generatedExpirationDate() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}

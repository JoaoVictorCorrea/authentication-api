package com.example.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.dtos.LoginResponseDTO;
import com.example.auth.dtos.UserAuthenticationDTO;
import com.example.auth.dtos.UserRegisterDTO;
import com.example.auth.entities.User;
import com.example.auth.services.TokenService;
import com.example.auth.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid UserAuthenticationDTO body) {
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(body.getLogin(), body.getPassword());
		
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generatedToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid UserRegisterDTO body) {
		
		var result = this.userService.save(body);
		
		if(result != null)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.badRequest().build();
	}
}

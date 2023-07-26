package com.example.auth.dtos;

import com.example.auth.enums.UserRole;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRegisterDTO {
	
	private String login;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}

package com.example.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth.dtos.UserRegisterDTO;
import com.example.auth.entities.User;
import com.example.auth.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(UserRegisterDTO user) {
		
		if(this.userRepository.findByLogin(user.getLogin()) != null)
			return null;
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		User newUser = new User(user.getLogin(), encryptedPassword, user.getRole());
		
		return this.userRepository.save(newUser);
	}
	
	public UserDetails findByLogin(String login) {
		
		return this.userRepository.findByLogin(login);
	}
}

package com.amdocs.media.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.media.auth.models.User;
import com.amdocs.media.auth.service.AuthService;
import com.amdocs.media.base.models.UserDTO;

@CrossOrigin
@RestController
@RequestMapping("/assignment")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> authorizeUser(@RequestBody User user) {
		User validUser = authService.getUser(user);
		if(validUser != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(validUser.getUserId());
			userDTO.setUsername(validUser.getUsername());
			
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/new-user")
	public User createUser(@RequestBody User user) {
		User newUser = authService.saveUser(user);		
		return newUser;
	}
	
}

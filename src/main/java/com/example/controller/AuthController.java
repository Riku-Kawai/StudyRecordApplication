package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.entity.UserEntity;
import com.example.model.form.UserForm;
import com.example.service.UserModuleService;

@RestController
public class AuthController {

	@Autowired
	private UserModuleService userModuleService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserForm userForm) {
		try {
			UserEntity user = new UserEntity();
			user.setUsername(userForm.getUsername());
			user.setPassword(userForm.getPassword());
			userModuleService.registerUser(user);
			return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	}

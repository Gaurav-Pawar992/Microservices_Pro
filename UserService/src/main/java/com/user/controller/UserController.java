package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// Create
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1= userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	// Single User Get
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String userID){
		
		User user1 = userService.getUser(userID);
		
		return ResponseEntity.ok(user1);
	}
	
	// Get All Users
	
	@GetMapping 
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		
		return ResponseEntity.ok(allUsers);
	}
	
}

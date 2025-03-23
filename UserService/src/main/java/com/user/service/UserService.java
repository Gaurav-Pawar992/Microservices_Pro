package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {

	// Create
	
	User saveUser (User user);
	
	// Get All Users
	
	List<User> getAllUsers();
	
	// User with Id
	
	User getUser(String userId);
	
}

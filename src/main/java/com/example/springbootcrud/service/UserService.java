package com.example.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import com.example.springbootcrud.entities.User;


public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	// public User getUserDetails(long userId);   // ek process ye bhi he singel user get karne ke liye 
	
	public Optional<User> getUserDetails(long userId);
	
	public User updateUserDetails(User newUser); 
	
	public void deleteUser(long userId);


}

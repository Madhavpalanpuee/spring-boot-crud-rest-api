package com.example.springbootcrud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcrud.entities.User;
import com.example.springbootcrud.service.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userservice;   // jo service class he usko ka object banaya he he 
	
	public 
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		
		return userservice.createUser(user);
		
	}
	
	// all user get ID
	@GetMapping("/user")
	public List<User> getAllUserDetails()
	{
		return userservice.getAllUser();
	}
	
	// Single user get id             // ek process ye bhi he singel user get karne ke liye 
	
//	@GetMapping("/user/{userId}")
//	public User getUserDetails(@PathVariable String userId)x
//	{
//		return userservice.getUserDetails(Long.parseLong(userId));
//	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserDetails(@PathVariable long userId)  // ResponseEntit ye isliye use kiya he kyu ki apn ko postmen prr bataye ga ki data he to "200 OK" bataye ga nahi toh "404 NotFound" Bataye ga 
	{                                                                      // nahi toh optional se bhi kaam ho jata yha bs 
		User user = userservice.getUserDetails(userId).orElse(null);
		
		if(user != null) 
		{
			return ResponseEntity.ok().body(user);    // yha orr jo responseEntity ke andar 200 OK or fie body ke andar us user ki detail daldunga
		}
		
		else
		{
			return ResponseEntity.notFound().build();   // agar search karne prr vo id nahi mili toh not found bata dega
		}
	}
	
	// update user using putRequest
	@PutMapping("/user")
	public User updateUserDetails(@RequestBody User newUser)
	{
		return userservice.updateUserDetails(newUser);
	}
	
	// Delete User 
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable long userId)
	{
		userservice.deleteUser(userId);
	//	return ResponseEntity.noContent().build();
	}

	
	

}

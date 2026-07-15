package com.example.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrud.Repositories.UserRepositories;
import com.example.springbootcrud.entities.User;

@Service						
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositories userRepositories;     // ye vali line jo user repositories he usko jpaRepositories se extand kar rkha he toh usme se sari method la kar degi vo apn ko jaise save,find,findAll ese sari metho he 
 
	@Override
	public User createUser(User user) {
		
		return userRepositories.save(user);
	}

	@Override
	public List<User> getAllUser() {
        
		userRepositories.findAll();
		return userRepositories.findAll();
	}

	

//	@Override
//	public User getUserDetails(long userId) {           // ek process ye bhi he singel user get karne ke liye 
//		
//		return userRepositories.getOne(userId);
//	}
	
	@Override
	public Optional<User> getUserDetails(long userId)
	{
		// TODO Auto-generated method stub
		return userRepositories.findById(userId);
	}

	@Override
	public User updateUserDetails(User newUser)
	{
		
		
		 userRepositories.save(newUser);
		 return newUser;
		}

	@Override
	public void deleteUser(long userId) {
	
		userRepositories.deleteById(userId);
		
	}			
}


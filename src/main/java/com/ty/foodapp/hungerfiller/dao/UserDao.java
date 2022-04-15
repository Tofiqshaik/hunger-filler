package com.ty.foodapp.hungerfiller.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.hungerfiller.dto.User;
import com.ty.foodapp.hungerfiller.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		return optional.get();
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public boolean deleteUserById(int id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public User updateUserById(User user) {
		return userRepository.save(user);
	}
}

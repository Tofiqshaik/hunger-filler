package com.ty.foodapp.hungerfiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp.hungerfiller.dao.ResponseStructure;
import com.ty.foodapp.hungerfiller.dao.UserDao;
import com.ty.foodapp.hungerfiller.dto.User;
import com.ty.foodapp.hungerfiller.exception.NoIdFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public ResponseStructure<User> saveUser(User user) {
		User user2 = userDao.saveUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successful");
		responseStructure.setData(user2);
		return responseStructure;
	}
	
	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		if (user == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		return user;
	}
	
	public ResponseStructure<User> getUser(int id) {
		User user = getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		if (user == null) {
			throw new NoIdFoundException("given "+id+" does not exist");
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successful");
		responseStructure.setData(user);
		return responseStructure;
	}
	
	public ResponseStructure<List<User>> getAllUser(){
		List<User> users = userDao.getAllUser();
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successful");
		responseStructure.setData(users);
		return responseStructure;
	}
	
	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
	
	public User updateUserById(int id, User user) {
		User extuser = getUserById(id);
		if (extuser != null) {
			return userDao.saveUser(user);
		}
		return null;
	}
}

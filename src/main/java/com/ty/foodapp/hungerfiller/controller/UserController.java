package com.ty.foodapp.hungerfiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.hungerfiller.dao.ResponseStructure;
import com.ty.foodapp.hungerfiller.dao.UserDao;
import com.ty.foodapp.hungerfiller.dto.User;
import com.ty.foodapp.hungerfiller.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@ApiOperation(value = " User  Has been saved", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "user saved sucessfully"),
			@ApiResponse(code = 405, message = "No User found ") })

	@PostMapping("/user")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@ApiOperation(value = "GET User DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "gets given User data"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/user")
	public ResponseStructure<User> getUserById(@RequestParam int id) {
		return userService.getUser(id);
	}

	@ApiOperation(value = "GET AllUser DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "gets given User data"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/alluser")
	public ResponseStructure<List<User>> getAllUser() {
		return userService.getAllUser();
	}

	@ApiOperation(value = " DELETE User DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given user data deleted successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@DeleteMapping("/user")
	public boolean deleteUser(@RequestParam int id) {
		return userService.deleteUserById(id);
	}

	@ApiOperation(value = " Update UserById ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given user data updated successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found to update") })

	@PatchMapping("/user")
	public User updateUserById(int id, User user) {
		return userService.updateUserById(id, user);
	}

}

package com.vladwick.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladwick.model.User;
import com.vladwick.model.UserRegistrationDto;
import com.vladwick.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "/users", tags = "users", description = "Set of methods for managing users")
public class Users {
	
	@Autowired
	public UserService userService;

	@ApiOperation(value = "Get all users", notes = "Returns all users")
	@GetMapping("/users")
	public ResponseEntity<List<User>> users() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users); 
	}
	
	/* ----- */
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@ApiOperation(value = "Add new user", notes = "Returns user that needs to be saved")
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		User savedUser = userService.save(registrationDto);
		return ResponseEntity.ok(savedUser);
	}
	/* ----- */
	
	@ApiOperation(value = "Get user by id", notes = "Returns a user as per the id")
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@ApiOperation(value = "Update user by id", notes = "Returns an updated user")
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User user = userService.getUserById(id);
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setBalance(userDetails.getBalance());
		user.setInfo(userDetails.getInfo());
		user.setPassword(userDetails.getPassword());
		
		User updatedUser = userService.saveUser(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@ApiOperation(value = "Delete user by id", notes = "Returns a successfull remove of the user")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		userService.deleteUserById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

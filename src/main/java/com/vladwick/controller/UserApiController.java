package com.vladwick.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladwick.model.User;
import com.vladwick.model.UserRegistrationDto;
import com.vladwick.service.UserService;

@Controller
@RequestMapping("/api/v1")
public class UserApiController {
	
	@Autowired
	public UserService userService;

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
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		User savedUser = userService.save(registrationDto);
		return ResponseEntity.ok(savedUser);
	}
	/* ----- */
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
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
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		userService.deleteUserById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

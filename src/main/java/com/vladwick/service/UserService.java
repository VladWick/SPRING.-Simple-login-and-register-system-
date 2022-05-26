package com.vladwick.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vladwick.model.Role;
import com.vladwick.model.User;
import com.vladwick.model.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	List<User> getAllUsers();
	User saveUser(User User);
	User updateUser(User User);
	User getUserById(Long id);
	void deleteUserById(Long id);
	
	
	
	User save(UserRegistrationDto registrationDto);	
	
}

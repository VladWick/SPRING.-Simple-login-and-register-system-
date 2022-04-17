package com.vladwick.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vladwick.model.User;
import com.vladwick.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);	
}

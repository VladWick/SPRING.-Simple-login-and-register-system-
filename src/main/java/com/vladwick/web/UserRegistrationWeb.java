package com.vladwick.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladwick.model.UserRegistrationDto;
import com.vladwick.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/registration") 
@ApiIgnore
public class UserRegistrationWeb {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}






package com.vladwick.web.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vladwick.model.Role;
import com.vladwick.model.User;
import com.vladwick.service.UserService;

import springfox.documentation.annotations.ApiIgnore;

@Controller 
@ApiIgnore
public class UserWeb {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "/user/users";
	}
	
	@GetMapping("/users/add")
	public String createUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/user/add_user";
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/users/update/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "/user/update_user";
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id, 
			@ModelAttribute("user") User User, 
			Model model) {
	
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFirstName(User.getFirstName());
		existingUser.setLastName(User.getLastName());
		existingUser.setEmail(User.getEmail());
		existingUser.setBalance(User.getBalance());
		existingUser.setInfo(User.getInfo());
		existingUser.setPassword(User.getPassword());
		
		existingUser.setRoles(Arrays.asList(new Role("USER")));
		
		userService.updateUser(existingUser);
		return "redirect:/users";
	}
	
	@GetMapping("users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}
	
	@GetMapping("users/details/{id}")
	public String userDetails(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "/user/user_details";
	}
}

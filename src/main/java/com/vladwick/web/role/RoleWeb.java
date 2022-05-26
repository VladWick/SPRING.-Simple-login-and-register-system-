package com.vladwick.web.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vladwick.service.RoleService;
import com.vladwick.service.UserService;

@Controller
public class RoleWeb {

	@Autowired
	public RoleService roleService;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/roles")
	public String roles(Model model) {
		model.addAttribute("roles", roleService.getAllRoles());
		model.addAttribute("users", userService.getAllUsers());
		return "/role/roles";
	}
	
}

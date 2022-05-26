package com.vladwick.web.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vladwick.service.RoleService;

@Controller
public class RoleWeb {

	@Autowired
	public RoleService roleService;
	
	@GetMapping("/roles")
	public String roles(Model model) {
		model.addAttribute("roles", roleService.getAllRoles());
		return "/role/roles";
	}
	
}

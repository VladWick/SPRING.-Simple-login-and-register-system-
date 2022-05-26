package com.vladwick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vladwick.model.Role;
import com.vladwick.service.RoleService;

@Controller
@RequestMapping("/api/v1")
public class RoleApiController {

	@Autowired
	public RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<List<Role>> roles() {
		List<Role> roles = roleService.getAllRoles();
		return ResponseEntity.ok(roles);
	}

}

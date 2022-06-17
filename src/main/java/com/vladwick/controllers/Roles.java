package com.vladwick.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladwick.model.Role;
import com.vladwick.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "/roles", tags = "roles", description = "Set of methods for managing roles")
public class Roles {

	@Autowired
	public RoleService roleService;

	@ApiOperation(value = "Get all roles", notes = "Returns all roles")
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> roles() {
		List<Role> roles = roleService.getAllRoles();
		return ResponseEntity.ok(roles);
	}

}

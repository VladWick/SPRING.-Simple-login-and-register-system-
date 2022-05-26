package com.vladwick.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vladwick.model.Role;

@Service
public interface RoleService {
	
	public List<Role> getAllRoles();
	
}

package com.vladwick.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladwick.model.Role;
import com.vladwick.repository.RoleRepository;
import com.vladwick.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
}

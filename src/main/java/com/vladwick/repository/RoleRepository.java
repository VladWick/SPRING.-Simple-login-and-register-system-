package com.vladwick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladwick.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}

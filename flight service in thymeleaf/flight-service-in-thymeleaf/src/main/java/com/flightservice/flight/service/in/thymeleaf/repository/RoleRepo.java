package com.flightservice.flight.service.in.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservice.flight.service.in.thymeleaf.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	
	Role findByName(String role);

}

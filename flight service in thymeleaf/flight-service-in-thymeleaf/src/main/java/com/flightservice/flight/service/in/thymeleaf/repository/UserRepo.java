package com.flightservice.flight.service.in.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservice.flight.service.in.thymeleaf.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}

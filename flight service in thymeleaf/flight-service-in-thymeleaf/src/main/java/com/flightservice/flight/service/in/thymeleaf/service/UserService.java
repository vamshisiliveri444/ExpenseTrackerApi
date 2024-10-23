package com.flightservice.flight.service.in.thymeleaf.service;

import com.flightservice.flight.service.in.thymeleaf.dto.RegisterDto;

public interface UserService {
	
	void createUser(RegisterDto registerDto);

}

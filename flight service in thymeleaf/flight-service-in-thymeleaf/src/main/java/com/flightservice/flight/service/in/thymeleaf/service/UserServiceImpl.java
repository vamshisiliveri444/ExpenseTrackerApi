package com.flightservice.flight.service.in.thymeleaf.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightservice.flight.service.in.thymeleaf.dto.RegisterDto;
import com.flightservice.flight.service.in.thymeleaf.entity.Role;
import com.flightservice.flight.service.in.thymeleaf.entity.User;
import com.flightservice.flight.service.in.thymeleaf.repository.RoleRepo;
import com.flightservice.flight.service.in.thymeleaf.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private RoleRepo roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public void createUser(RegisterDto registerDto) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode( registerDto.getPassword()));
		Role role=roleRepository.findByName("ROLE_GUEST");
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
		
		
	}

}

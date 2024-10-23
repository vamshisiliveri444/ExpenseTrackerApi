package com.flightservice.flight.service.in.thymeleaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightservice.flight.service.in.thymeleaf.entity.User;
import com.flightservice.flight.service.in.thymeleaf.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(username);
		
		org.springframework.security.core.userdetails.User user1=new 
				org.springframework.security.core.userdetails.User(
						user.getEmail(),
						user.getPassword(),
						user.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getName())).toList()
						);
		return user1;
	}

}

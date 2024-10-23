package com.flightservice.flight.service.in.thymeleaf.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.flightservice.flight.service.in.thymeleaf.security.CustomUserDetailsService;

@Configuration
public class AppConfig {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize->
				authorize
			.requestMatchers("/**").permitAll()
			.requestMatchers("/register/**").permitAll()
			.requestMatchers("/admin/**").hasAnyRole("GUEST","ADMIN")
			.anyRequest().authenticated()
		)
		.formLogin(form->
			form
			.loginPage("/showLoginPage")
			
			.loginProcessingUrl("/login")
			.permitAll()
			
		)
		.logout(logout->logout
				//.logoutSuccessUrl("/showLoginPage")
				.permitAll()
				
				)
		;
		return http.build();
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder builder) throws Exception {
			builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
			
			
	}
	
	
	
	
	
	

}

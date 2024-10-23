package com.flightservice.flight.service.in.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flightservice.flight.service.in.thymeleaf.dto.RegisterDto;
import com.flightservice.flight.service.in.thymeleaf.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register")
	public String signUp(Model model) {
		
		RegisterDto registerDto=new RegisterDto();
		model.addAttribute("registerDto", registerDto);
		return "register";
		
	}
	
	@PostMapping("/register/save")
	public String signUpRegistration(@Valid @ModelAttribute("registerDto") RegisterDto registerDto,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("registerDto", registerDto);
			return "register";
		}
		userService.createUser(registerDto);
		return "register";
		
	}
	
	@GetMapping("/showLoginPage")
	public String signIn() {
		return "/login";
		
	}
	
	

}

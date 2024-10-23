package com.flightservice.flight.service.in.thymeleaf.dto;

import com.flightservice.flight.service.in.thymeleaf.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	private long id;
	@NotBlank
	private String username;
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	@NotBlank
	private String password;

}

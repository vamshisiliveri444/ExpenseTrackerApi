package com.flightservice.flight.service.in.thymeleaf.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDto {
	
	private long id;
	@NotBlank(message="name must")
	private String name;
	@Column(unique = true)
	@NotBlank(message="email is need")
	private String email;
	@NotBlank(message="phone number is need")
	private String phoneNumber;
	
	
	private int noOfSeats=1;

}

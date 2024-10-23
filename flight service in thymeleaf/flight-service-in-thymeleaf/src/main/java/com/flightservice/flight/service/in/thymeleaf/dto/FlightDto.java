package com.flightservice.flight.service.in.thymeleaf.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
	
	private long id;
	@NotBlank(message="Airline company needed")
	private String name;
	@NotBlank(message="please enter the origin")
	private String source;
	@NotBlank(message="please enter the destination")
	private String destination;
	
	@NotNull(message="start date is mandatory")
	private Date startDate;
	@NotNull(message="arrival date is mandatory")
	private Date endDate=startDate;
	@NotNull(message="please enter seating capacity")
	private long seats;
	@NotNull(message="please enter price of each seat")
	private double price;
	
	private int discount;
}

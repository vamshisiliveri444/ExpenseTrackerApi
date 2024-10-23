package com.flightservice.flight.service.in.thymeleaf.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightResponse {
	private long id;
	private String name;
	private String source;
	private String destination;
	private Date startDate;
	private Date endDate;
	private double price;
	private List<PassengerDto>passengerDto;

}

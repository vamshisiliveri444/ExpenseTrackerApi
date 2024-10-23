package com.flightservice.flight.service.in.thymeleaf.service;

import java.sql.Date;
import java.util.List;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightDto;

public interface FlightService {
	
	List<FlightDto> getAllFlights();
	void createFlight(FlightDto flightDto);
	
	List<FlightDto>findAllFlightsByQuery(String query);
	
	List<FlightDto>getByFliters(String source,String destination,Date dateOfTravel);
	

}

package com.flightservice.flight.service.in.thymeleaf.service;

import java.util.List;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightResponse;
import com.flightservice.flight.service.in.thymeleaf.dto.PassengerDto;

public interface PassengerService {
	
	void createPassenger(Long flightId,PassengerDto passengerDto);
	
	FlightResponse getAllPassengerByFlightId(Long flightId);
	

}

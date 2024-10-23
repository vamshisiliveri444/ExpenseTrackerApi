package com.flightservice.flight.service.in.thymeleaf.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightDto;
import com.flightservice.flight.service.in.thymeleaf.entity.Flight;
import com.flightservice.flight.service.in.thymeleaf.mapper.FlightMapper;
import com.flightservice.flight.service.in.thymeleaf.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<FlightDto> getAllFlights() {
		// TODO Auto-generated method stub
		List<Flight>flights=flightRepository.findAll();
		
		return flights.stream().map(FlightMapper::mapToFlightDto).toList();
	}

	@Override
	public void createFlight(FlightDto flightDto) {
		// TODO Auto-generated method stub
		Flight flight=FlightMapper.mapToFlight(flightDto);
		flightRepository.save(flight);
		
		
	}

	@Override
	public List<FlightDto> findAllFlightsByQuery(String query) {
		// TODO Auto-generated method stub
		List<Flight>flights=flightRepository.findByNameAndSourceAndDestinationContaining(query);
		
		return flights.stream().map(FlightMapper::mapToFlightDto).toList();
	}

	@Override
	public List<FlightDto> getByFliters(String source, String destination, Date dateOfTravel) {
		// TODO Auto-generated method stub
		List<Flight>flights=flightRepository.findBySourceAndDestinationAndStartDateGreaterThanEqual(source, destination, dateOfTravel);
		
		return flights.stream().map(FlightMapper::mapToFlightDto).toList();
	}

}

package com.flightservice.flight.service.in.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightResponse;
import com.flightservice.flight.service.in.thymeleaf.dto.PassengerDto;
import com.flightservice.flight.service.in.thymeleaf.entity.Flight;
import com.flightservice.flight.service.in.thymeleaf.entity.Passenger;
import com.flightservice.flight.service.in.thymeleaf.mapper.FlightMapper;
import com.flightservice.flight.service.in.thymeleaf.mapper.PassengerMapper;
import com.flightservice.flight.service.in.thymeleaf.repository.FlightRepository;
import com.flightservice.flight.service.in.thymeleaf.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public void createPassenger(Long flightId,PassengerDto passengerDto) {
		// TODO Auto-generated method stub
		Flight flight=flightRepository.findById(flightId).get();
		Passenger passenger=PassengerMapper.mapToPassenegerDto(passengerDto);
		passenger.setFlight(flight);
		flight.setSeats(flight.getSeats()-passengerDto.getNoOfSeats());
		flightRepository.save(flight);
		passengerRepository.save(passenger);
		
	}

	@Override
	public FlightResponse getAllPassengerByFlightId(Long flightId) {
		// TODO Auto-generated method stub
		Flight flight=flightRepository.findById(flightId).get();
		FlightResponse response=FlightMapper.mapToFlightResponse(flight);
		List<Passenger>passengers=passengerRepository.findByFlightId(flightId);
		List<PassengerDto>dto=passengers.stream().map(PassengerMapper::mapToPasseneger).toList();
		response.setPassengerDto(dto);
		
		
		return response;
	}

}

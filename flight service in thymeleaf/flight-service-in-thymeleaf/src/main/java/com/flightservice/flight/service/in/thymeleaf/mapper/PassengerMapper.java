package com.flightservice.flight.service.in.thymeleaf.mapper;

import com.flightservice.flight.service.in.thymeleaf.dto.PassengerDto;
import com.flightservice.flight.service.in.thymeleaf.entity.Passenger;

public class PassengerMapper {
	
	public static PassengerDto mapToPasseneger(Passenger passenger) {

		PassengerDto passengerDto = new PassengerDto().builder().id(passenger.getId()).name(passenger.getName())
				.email(passenger.getEmail()).phoneNumber(passenger.getPhoneNumber()).noOfSeats(passenger.getNoOfSeats())
				.build();
		return passengerDto;

	}
	
	public static Passenger mapToPassenegerDto(PassengerDto passenger) {

		Passenger passengerDto = new Passenger().builder().id(passenger.getId()).name(passenger.getName())
				.email(passenger.getEmail()).phoneNumber(passenger.getPhoneNumber()).noOfSeats(passenger.getNoOfSeats())
				.build();
		return passengerDto;

	}

}

package com.flightservice.flight.service.in.thymeleaf.mapper;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightDto;
import com.flightservice.flight.service.in.thymeleaf.dto.FlightResponse;
import com.flightservice.flight.service.in.thymeleaf.entity.Flight;

public class FlightMapper {
	
	//map flight to flightdto;
	public static FlightDto mapToFlightDto(Flight flight) {
		
		FlightDto flightDto=new FlightDto()
				.builder()
				.id(flight.getId())
				.name(flight.getName())
				.source(flight.getSource())
				.destination(flight.getDestination())
				.startDate(flight.getStartDate())
				.endDate(flight.getEndDate())
				.price(flight.getPrice())
				.seats(flight.getSeats())
				.discount(flight.getDiscount())
				.build();
		return flightDto;
		
	}
	
	public static Flight mapToFlight(FlightDto flight) {
		Flight flight1=new Flight()
				.builder()
				.id(flight.getId())
				.name(flight.getName())
				.source(flight.getSource())
				.destination(flight.getDestination())
				.startDate(flight.getStartDate())
				.endDate(flight.getEndDate())
				.price(flight.getPrice())
				.seats(flight.getSeats())
				.discount(flight.getDiscount())
				.build();
		return flight1;
	}
public static FlightResponse mapToFlightResponse(Flight flight) {
		
		FlightResponse flightDto=new FlightResponse()
				.builder()
				.id(flight.getId())
				.name(flight.getName())
				.source(flight.getSource())
				.destination(flight.getDestination())
				.startDate(flight.getStartDate())
				.endDate(flight.getEndDate())
				.price(flight.getPrice())
				//.seats(flight.getSeats())
				//.discount(flight.getDiscount())
				.build();
		return flightDto;
		
	}

}

package com.flightservice.flight.service.in.thymeleaf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightservice.flight.service.in.thymeleaf.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	
	List<Passenger>findByFlightId(Long flightId);

}

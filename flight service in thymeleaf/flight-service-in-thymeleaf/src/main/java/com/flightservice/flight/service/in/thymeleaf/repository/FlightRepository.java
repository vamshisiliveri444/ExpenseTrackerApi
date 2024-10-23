package com.flightservice.flight.service.in.thymeleaf.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightservice.flight.service.in.thymeleaf.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	
	@Query("SELECT f from Flight f WHERE "+
			 "f.name LIKE %:query% OR "+
			"f.source LIKE %:query% OR "+
			 
			 "f.destination LIKE %:query%"
			)
	List<Flight>findByNameAndSourceAndDestinationContaining(String query);
	
	List<Flight>findBySourceAndDestinationAndStartDateGreaterThanEqual(String source,String destination,Date dateOfTravel);

}

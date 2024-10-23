package com.flightservice.flight.service.in.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightResponse;
import com.flightservice.flight.service.in.thymeleaf.dto.PassengerDto;
import com.flightservice.flight.service.in.thymeleaf.service.FlightService;
import com.flightservice.flight.service.in.thymeleaf.service.PassengerService;

@Controller
//@RequestMapping("/public")
public class PassengerController {
	
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping(value="/admin/booking/{flightId}")
	public String bookPassenger(@PathVariable("flightId")Long flightId ,Model model) {
		PassengerDto passengerDto=new PassengerDto();
		model.addAttribute("passengerDto", passengerDto);
		model.addAttribute("flightId", flightId);
		return "public/show-passenger.html";
	}
	
	@GetMapping(value="/admin/booking/{flightId}/info")
	public String flightInfo(@PathVariable("flightId")Long flightId ,Model model) {
		FlightResponse response=passengerService.getAllPassengerByFlightId(flightId);
		model.addAttribute("flightResponse", response);
		return "public/show-flightInfo.html";
	}
	
	@PostMapping("/admin/booking/{flightId}")
	public String submitPassenger(@PathVariable("flightId") Long flightId,
			@ModelAttribute("passengerDto") PassengerDto passengerDto) {
		passengerService.createPassenger(flightId, passengerDto);
		return "redirect:/admin/allFlights";
		
	}

}

package com.flightservice.flight.service.in.thymeleaf.controller;

import java.net.http.HttpClient.Redirect;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightservice.flight.service.in.thymeleaf.dto.FlightDto;
import com.flightservice.flight.service.in.thymeleaf.mapper.FlightMapper;
import com.flightservice.flight.service.in.thymeleaf.service.FlightService;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/admin") 
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	
	@GetMapping("/")
	public String getAllFlights(Model model) {
		List<FlightDto>flightDto=flightService.getAllFlights();
		model.addAttribute("flightDto", flightDto);
		return "admin/list-flights";
	}
	
	@GetMapping("/admin/allFlights/search")
	public String getListOfFlightsByKeyword(@RequestParam("query") String query,Model model) {
		List<FlightDto>flightDtos=flightService.findAllFlightsByQuery(query);
		System.out.println(query);
		
		model.addAttribute("flightDto", flightDtos);
		FlightDto flightDto=flightDtos.get(0);
		System.out.println(flightDto.getSource()+" "+flightDto.getDestination());
		return "admin/list-flights";
	}
	
	
	@GetMapping("/admin/allFlights/filter")
	public String getFormForTravel() {
		
		return "admin/show-filter";
	}
	
	@GetMapping("/admin/allFlights/filter/travel")
	public String getListOfFlightsByFilters(@RequestParam("source") String source,@RequestParam("destination") String destination,@RequestParam("dateOfTravel") Date dateOfTravel, Model model) {
		List<FlightDto>flightDtos=flightService.getByFliters(source, destination, dateOfTravel);
		
		
		model.addAttribute("flightDto", flightDtos);
		
		
		return "admin/list-flights";
	}
	
	
	@GetMapping("admin/showRegistration/flight")
	public String showFormToAddFlight(Model model) {
		FlightDto flightDto=new FlightDto();
		model.addAttribute("flightDto",flightDto);
		return "admin/show-flight-registration";
		
		
	}
	
	@PostMapping("admin/flight/add")
	public String addFlight(@Valid @ModelAttribute("flightDto") FlightDto flightDto,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("flightDto",flightDto);
			return "admin/show-flight-registration";
		}
		flightService.createFlight(flightDto);
		
		return "admin/home";
	}
	
	
}

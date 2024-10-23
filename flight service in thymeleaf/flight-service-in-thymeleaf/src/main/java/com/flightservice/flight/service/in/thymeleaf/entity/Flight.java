package com.flightservice.flight.service.in.thymeleaf.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message="Airline company needed")
	private String name;
	@NotBlank(message="please enter the origin")
	private String source;
	@NotBlank(message="please enter the destination")
	private String destination;
	
	private Date startDate;
	
	private Date endDate;
	@NotNull(message="please enter seating capacity")
	private long seats;
	@NotNull(message="please enter price of each seat")
	private double price;
	
	private int discount;
	
	@OneToMany(mappedBy = "flight")
	private List<Passenger>passengers;
	
	@CreationTimestamp
	private LocalDateTime createAt;
	@UpdateTimestamp
	private LocalDateTime updateAt;

}

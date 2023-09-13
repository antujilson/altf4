package com.ust.airlines.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ust.airlines.entity.Airline;
import com.ust.airlines.entity.Airport;
import com.ust.airlines.entity.Routes;
import com.ust.airlines.service.AirlineService;

@RestController
@RequestMapping("/api")
public class AirlineController {
	@Autowired
	private AirlineService jds;
	@GetMapping("/airline")
    public ResponseEntity<String> fetchAirline() throws IOException {
		return ResponseEntity.ok(jds.readAirlne("C:\\Hackathon\\airlines.json"));
		

}
	@GetMapping("/airport")
    public ResponseEntity<String> fetchAirport() throws IOException {
    	return ResponseEntity.ok(jds.readAirport("C:\\Hackathon\\airport.json"));
    }
	@GetMapping("/routes")
	public List<Routes> getRoutes()
	{
		return jds.readRoutes();
	}
	
	@GetMapping("/airline/{code}")
    public ResponseEntity<Airline> fetchAirlineByCode(@PathVariable String code) {
		List<Airline> airlines = jds.getAirlineByCode(code);
        Optional<Airline> airline = airlines.stream()
                .filter(a -> a.getCode().equalsIgnoreCase(code))
                .findFirst();
        return airline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    
	}
	@GetMapping("/airport/{code}")
    public ResponseEntity<Airport> fetchAirportByCode(@PathVariable String code) {
		List<Airport> airlines = jds.getAirportByCode(code);
        Optional<Airport> airline = airlines.stream()
                .filter(a -> a.getCode().equalsIgnoreCase(code))
                .findFirst();
        return airline.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    
	}
	}

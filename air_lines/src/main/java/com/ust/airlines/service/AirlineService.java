package com.ust.airlines.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.airlines.entity.Airline;
import com.ust.airlines.entity.Airport;
import com.ust.airlines.entity.Routes;
import com.ust.airlines.repo.AirlineRepository;
import com.ust.airlines.repo.AirportRepository;
import com.ust.airlines.repo.RoutesRepository;



@Service
public class AirlineService {

	    @Autowired
	    private AirlineRepository ar;
	    @Autowired
	    private AirportRepository br;
	    @Autowired
	    private RoutesRepository cr;
	    public List<Airline> getAllAirlines() {
	        return ar.findAll();
	    }

	    
	    //reading airline 
	    public String readAirlne(String filePath) throws IOException {
	        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
	        String jsonContent= new String(bytes, StandardCharsets.UTF_8);
	        ObjectMapper objectMapper = new ObjectMapper();
	        Airline[] airline=objectMapper.readValue(jsonContent,Airline[].class);
	        List<Airline> airlines=new ArrayList();
	        for(Airline am:airline) {
	        	airlines.add(am);
	        }

	        ar.saveAll(airlines);

	        return  new String(bytes, StandardCharsets.UTF_8);
//	        ObjectMapper objectMapper = new ObjectMapper();
	    }
	    
	    //reading airport details
	    public String readAirport(String filePath) throws IOException {
	        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
	        String jsonContent= new String(bytes, StandardCharsets.UTF_8);
	        ObjectMapper objectMapper = new ObjectMapper();
	        Airport[] airline=objectMapper.readValue(jsonContent,Airport[].class);
	        List<com.ust.airlines.entity.Airport> airlines=new ArrayList();
	        for(Airport am:airline) {
	        	airlines.add(am);
	        }
	    for(Airport am:airline) {
	    	try {
	        br.save(am);
	    	}
	    	catch (Exception e) {
	    		// TODO: handle exception
	    		
	    		System.out.println(am.getState());
	    		
	    	}
	    }

	        return  new String(bytes, StandardCharsets.UTF_8);
//	        ObjectMapper objectMapper = new ObjectMapper();
	    }
	    
//	    //reading routes
//	    public String readRoutes(String filePath) throws IOException {
//	        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
//	        String jsonContent= new String(bytes, StandardCharsets.UTF_8);
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        Routes[] airline=objectMapper.readValue(jsonContent,Routes[].class);
//	        List<Routes> airlines=new ArrayList();
//	        for(Routes am:airline) {
//	        	airlines.add(am);
//	        }
//	    for(Routes am:airline) {
//	    	try {
//	        cr.save(am);
//	    	}
//	    	catch (Exception e) {
//	    		// TODO: handle exception
//	    		
//	    		System.out.println(am.getId());
//	    		
//	    	}
//	    }

//	        return  new String(bytes, StandardCharsets.UTF_8);
////	        ObjectMapper objectMapper = new ObjectMapper();
//	    }
//	    
	    //reading airline by code
	    public List<Airline> getAirlineByCode(String code) {
	        return ar.findByAirlineCode(code);
	    }
	    
	    //reading airport by code
	    public List<Airport> getAirportByCode(String code) {
	        return br.findByAirportCode(code);
	    }
	    
	    public List<Routes> readRoutes() {
	        ObjectMapper objectMapper = new ObjectMapper();

	        try {
	            // Replace "example.json" with your JSON file's path
	            File RoutesFile = new File("C:\\Hackathon\\flightsDB.routes_v2.json");
	            List<Routes> routes = objectMapper.readValue(RoutesFile, new TypeReference<List<Routes>>() {});
	            for(Routes r:routes)
	            {
	            	
	             cr.save(r);
	            }

	            // Now, you have a list of Airline objects
	          return routes;
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle the exception appropriately
	           return null;
	        }
	}
	    
	    



}

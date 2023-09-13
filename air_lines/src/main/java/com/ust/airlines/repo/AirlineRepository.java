package com.ust.airlines.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.airlines.entity.Airline;


@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long>{
	
	 @Query("SELECT a FROM Airline a WHERE a.code = :code")
	 List<Airline> findByAirlineCode(String code);

	    
}

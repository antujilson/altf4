package com.ust.airlines.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ust.airlines.entity.Airport;
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	@Query("SELECT a FROM Airport a WHERE a.code = :code")
	 List<Airport> findByAirportCode(String code);

}

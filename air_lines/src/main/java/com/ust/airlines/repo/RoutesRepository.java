package com.ust.airlines.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.airlines.entity.Routes;
@Repository
public interface RoutesRepository extends JpaRepository<Routes,Long> {

}

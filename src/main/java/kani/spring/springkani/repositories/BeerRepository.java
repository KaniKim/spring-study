package kani.spring.springkani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import kani.spring.springkani.entities.Beer;

public interface BeerRepository extends JpaRepository<Beer, UUID>{
    
}

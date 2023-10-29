package kani.spring.springkani.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import kani.spring.springkani.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
    
}

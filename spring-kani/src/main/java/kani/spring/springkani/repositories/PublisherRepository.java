package kani.spring.springkani.repositories;

import org.springframework.data.repository.CrudRepository;

import kani.spring.springkani.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}

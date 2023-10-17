package kani.spring.springkani.repositories;

import org.springframework.data.repository.CrudRepository;

import kani.spring.springkani.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    
}

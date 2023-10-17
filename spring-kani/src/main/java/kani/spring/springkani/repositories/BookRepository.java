package kani.spring.springkani.repositories;

import org.springframework.data.repository.CrudRepository;

import kani.spring.springkani.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
    
}

package kani.spring.springkani.services;

import kani.spring.springkani.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
    
}

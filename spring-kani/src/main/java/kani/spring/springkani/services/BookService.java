package kani.spring.springkani.services;

import kani.spring.springkani.domain.Book;

public interface BookService {
    
    Iterable<Book> findAll();

}

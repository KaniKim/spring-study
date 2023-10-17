package kani.spring.springkani.services;

import org.springframework.stereotype.Service;

import kani.spring.springkani.domain.Author;
import kani.spring.springkani.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
    
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}

package kani.spring.springkani.services;

import org.springframework.stereotype.Service;

import kani.spring.springkani.domain.Book;
import kani.spring.springkani.repositories.BookRepository;

@Service
public class BookerServiceImpl implements BookService{
    
    private final BookRepository bookRepository;

    public BookerServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}

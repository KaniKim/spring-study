package kani.spring.springkani.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kani.spring.springkani.domain.Author;
import kani.spring.springkani.domain.Book;
import kani.spring.springkani.repositories.AuthorRepository;
import kani.spring.springkani.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book DDD = new Book();
        DDD.setTitle("Domain Driven Design");
        DDD.setIsbn("123456");
        
        Author ericSaved = authorRepository.save(eric);
        Book DDDSaved = bookRepository.save(DDD);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        
        ericSaved.getBooks().add(DDDSaved);
        rodSaved.getBooks().add(noEJBSaved);

        System.out.println("InBootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
    
}

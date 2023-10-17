package kani.spring.springkani.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kani.spring.springkani.domain.Author;
import kani.spring.springkani.domain.Book;
import kani.spring.springkani.domain.Publisher;
import kani.spring.springkani.repositories.AuthorRepository;
import kani.spring.springkani.repositories.BookRepository;
import kani.spring.springkani.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
        DDDSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher savedPublisher = publisherRepository.save(publisher);

        DDDSaved.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);
        bookRepository.save(DDDSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("InBootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
    
}

package com.roy.spring5webapp.bootstrap;

import com.roy.spring5webapp.domain.Author;
import com.roy.spring5webapp.domain.Book;
import com.roy.spring5webapp.domain.Publisher;
import com.roy.spring5webapp.repository.AuthorRepository;
import com.roy.spring5webapp.repository.BookRepository;
import com.roy.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Roy 28-10-2021
 */
@Component // to tell this is a spring managed component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    /*
    After Spring implements these components
    it will do Dependency Injection for the instance
    of author and book repos
     */
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        Spring Data JPA is utilizing Hibernate to save these 2
        in memory H2 database
         */
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Peterburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);



        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);//adding book to the author
        ddd.getAuthors().add(eric);// adding author to the book

        ddd.setPublisher(publisher);// adding publisher to book
        publisher.getBooks().add(ddd);// vice-versa

        //saving into H2 database
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod","Jhonson");
        Book noEJB = new Book("J2EE","9384573894");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: "+ publisherRepository.count());

        System.out.println("No. of Books: "+ bookRepository.count());
        System.out.println("Publisher no. of books: "+ publisher.getBooks().size());
    }
}

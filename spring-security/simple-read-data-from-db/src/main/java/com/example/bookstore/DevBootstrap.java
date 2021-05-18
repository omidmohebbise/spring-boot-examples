package com.example.bookstore;

import com.example.bookstore.entity.*;

import com.example.bookstore.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorsRepository authorsRepository ;
    private BooksRepository booksRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorsRepository authorsRepository, BooksRepository booksRepository, PublisherRepository publisherRepository) {
        this.authorsRepository = authorsRepository;
        this.booksRepository = booksRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();

    }

    private void initData() {

        Publisher publisher = new Publisher("Packet","Amercan");
        publisherRepository.save(publisher);


        Author author = new Author("omid","mohebbi",25);
        Book  book = new Book("C++" , new Date() ,2000);

        book.setPublisher(publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        booksRepository.save(book);

        authorsRepository.save(author);


        Author author1 = new Author("ali","ahmadi",25);
        Author author2 = new Author("amir","sadeghi",25);
        Author author3 = new Author("haed","shahbi",25);


        authorsRepository.save(author1);
        authorsRepository.save(author2);
        authorsRepository.save(author3);

        /*Author author1 = new Author("ali" , "ahmadi",30);
        Book b = new Book("java", new Date(), 3000);
        author1.getBooks().add(b);
*/
        //authorsRepository.save(author1);
       // booksRepository.save(b);


    }
}

package omid.spring.example.springexample.bookstore;

import omid.spring.example.springexample.bookstore.model.Author;
import omid.spring.example.springexample.bookstore.model.Book;
import omid.spring.example.springexample.bookstore.model.Publisher;
import omid.spring.example.springexample.bookstore.repositories.AuthorsRepository;
import omid.spring.example.springexample.bookstore.repositories.BooksRepository;
import omid.spring.example.springexample.bookstore.repositories.PublisherRepository;
import oracle.net.aso.b;
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


        /*Author author1 = new Author("ali" , "ahmadi",30);
        Book b = new Book("java", new Date(), 3000);
        author1.getBooks().add(b);
*/
        //authorsRepository.save(author1);
       // booksRepository.save(b);


    }
}

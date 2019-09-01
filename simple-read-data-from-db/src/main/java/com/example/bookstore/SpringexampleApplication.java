package omid.spring.example.springexample.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


//@SpringBootApplication
public class SpringexampleApplication {

    public  void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(SpringexampleApplication.class, args);
    }

}


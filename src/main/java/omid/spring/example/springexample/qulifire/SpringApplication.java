package omid.spring.example.springexample.qulifire;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringApplication {


    @SpringBootApplication
    public class SpringexampleApplication {
        //public static void main(String[] args) {
        public  void main(String[] args) {

            ConfigurableApplicationContext contex =  org.springframework.boot.SpringApplication.run(omid.spring.example.springexample.bookstore.SpringexampleApplication.class, args);

            SimpleControllerQuailifier.testBean(contex);

        }

    }
}

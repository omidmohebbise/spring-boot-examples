package omid.spring.example.springexample.qulifire;

import omid.spring.example.springexample.SpringexampleApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringApplication {


    @SpringBootApplication
    public class SpringexampleApplication {
        //public static void main(String[] args) {
        public  void main(String[] args) {

            ConfigurableApplicationContext contex =  org.springframework.boot.SpringApplication.run(omid.spring.example.springexample.SpringexampleApplication.class, args);

            SimpleControllerQuailifier.testBean(contex);

        }

    }
}

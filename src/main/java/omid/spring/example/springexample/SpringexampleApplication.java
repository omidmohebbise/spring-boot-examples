package omid.spring.example.springexample;

import omid.spring.example.springexample.qulifire.SimpleControllerQuailifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class SpringexampleApplication {

    public    void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(SpringexampleApplication.class, args);
    }

}


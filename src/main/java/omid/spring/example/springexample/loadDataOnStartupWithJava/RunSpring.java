package omid.spring.example.springexample.loadDataOnStartupWithJava;

import omid.spring.example.springexample.SpringexampleApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunSpring {
    public  static  void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }

}

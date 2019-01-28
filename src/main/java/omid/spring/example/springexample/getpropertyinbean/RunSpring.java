package omid.spring.example.springexample.getpropertyinbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunSpring {
    public  static  void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }

}

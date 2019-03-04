package omid.spring.example.springexample.loadDataOnStartupWithJava;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class RunSpring {
    public  void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }

}

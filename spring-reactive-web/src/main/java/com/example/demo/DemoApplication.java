package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
    private final GreetingClient greetingClient;

    public DemoApplication(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    public static void main(String[] args) {
         SpringApplication.run(DemoApplication.class, args);
    }

    private static int counter = 0;
    private static int responseCounter = 0;
    //@Scheduled(fixedRate = 10)
    public void timer() {
        if (greetingClient != null && counter < 1000) {

            greetingClient.getMessage(counter++).subscribe(s -> {
                responseCounter++;
                System.out.println( "total count: " + counter + " ====> current = " + s);
            });
        }else{
            System.out.println("total response "  + responseCounter);
        }
    }


}

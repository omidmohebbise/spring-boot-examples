package omid.spring.example.springexample.lifecycle;

import omid.spring.example.springexample.SpringexampleApplication;
import omid.spring.example.springexample.qulifire.SimpleControllerQuailifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLOutput;
@SpringBootApplication
public class SpringApplication  implements ApplicationRunner {

        public static void main(String[] args) {
            System.out.println("Spring Life Cycle");

            ConfigurableApplicationContext contex =  org.springframework.boot.SpringApplication.run(SpringApplication.class, args);



        }


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

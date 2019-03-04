package omid.spring.example.springexample.lifecycle;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
public class SpringApplication  implements ApplicationRunner {

        public  void main(String[] args) {
            System.out.println("Spring Life Cycle");

            ConfigurableApplicationContext contex =  org.springframework.boot.SpringApplication.run(SpringApplication.class, args);



        }


    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}

package omid.spring.example.springexample.getpropertyinbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleComponent implements CommandLineRunner {

    @Value("omid.property")
    public String propertyAttr;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("propertyAttr =====>" + propertyAttr);


    }
}

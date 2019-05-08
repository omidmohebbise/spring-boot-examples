package security.securityinmemory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class SecurityInmemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityInmemoryApplication.class, args);
    }

    @RestController
    public class MyController{

        @RequestMapping("/secured")
        public String getSecuredHelloWorld(){
            return "<a href=\"logout\"> log from seured result</a>";
        }

        @RequestMapping("/home")
        public String getHomeHelloWorld(){
            return "Hello Home World";
        }

    }
}

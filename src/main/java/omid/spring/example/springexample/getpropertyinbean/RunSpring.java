package omid.spring.example.springexample.getpropertyinbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
public class RunSpring {
    public  static  void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }


}
@Service
class Test{
    @RequestMapping({"/hello","/he",""})
    public String test(){
        return "books";
    }

}

package omid.spring.example.springexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @RequestMapping("/api/helloworld")
    public String getHelloWorld(){
        return "Hello World";
    }
}

package omid.spring.example.springexample.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
public class SimpleController  extends BaseController{

    @RequestMapping({"/exceptionhandler","/eh"})
    public String returnSomeThing(){
        int a = 10;
        int b = 0;
        b = a / b;
        return "hello";
    }

}

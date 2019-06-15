package com.example.exceptionhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ExceptionhandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionhandlerApplication.class, args);
    }




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
}

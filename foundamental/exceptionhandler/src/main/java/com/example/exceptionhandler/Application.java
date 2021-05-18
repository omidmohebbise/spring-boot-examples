package com.example.exceptionhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class SimpleController  extends BaseController{

        //@ExceptionHandler({Exception.class})
        @RequestMapping({"/exceptionhandler","/eh"})
        public String returnSomeThing(){
            int a = 10;
            int b = 0;
            b = a / b;
            return "hello";
        }
        @RequestMapping({"/exceptionhandler1","/eh1"})
        public String returnSomeThing1(){
           String str = null;
           if(false)
               str = "test";

            System.out.println(str.length());
            return "hello";
        }

        @RequestMapping({"/{var}/exceptionhandler2"})
        public String urlVariable(@PathVariable String pathVar){
            System.out.println(pathVar);
            return pathVar;
        }

        @RequestMapping({"/*"})
        public String other(){
            if(true) throw new WrongUrlException("wrong URL");
            return "Wrong URL";
        }

    }

    /*@Controller
    public class AppErrorController implements ErrorController {

        @Override
        public String getErrorPath() {
            //if(true)throw new NullPointerException("dsd");
            return "/error";
        }
    }*/

}

package omid.spring.example.springexample.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ServletComponentScan
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class RunSpring {
    public  static   void main(String[] args) {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }

    @RestController
    public class SimpleRest{

        @RequestMapping("/secured")
        public String securedRest(){
            return "I am secured rest";
        }

        @RequestMapping("/unsecured")
        public String unsecuredRest(){
            return "I am unsecured rest";
        }


        @RequestMapping("/test")
        public String anotherMethhod0(){
            return "I am anotherMethhod0";
        }

        @RequestMapping("/test1")
        public String anotherMethhod1(){
            return "I am anotherMethhod1";
        }


        @RequestMapping("/ineedadminrole")
        public String getSthForAdmin(){
            return "I am Sth For Admin";
        }

        @RequestMapping("/methodrole")
        @Secured("ROLE_MANAGER")
        public String testMethodSecurity(){
            return "testMethodSecurity is ok for MANAGER role";
        }



    }



}

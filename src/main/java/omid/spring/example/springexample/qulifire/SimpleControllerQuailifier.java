package omid.spring.example.springexample.qulifire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;



 interface GreetingService {
     public void sayHello();
 }
@Service
@Profile("fa")
 class GreetingServiceImpl implements  GreetingService{

     @Override
     public void sayHello() {
         System.out.println("GreetingServiceImpl");
     }
 }

@Service
//@Primary
@Profile("es")//according to the profile that has been set in .properties
class GetterGreetingService implements  GreetingService{
     @Override
    public void sayHello() {
        System.out.println("GetterGreetingService");
    }
}

@RestController
public class SimpleControllerQuailifier {

    /**
     * this method used to called in main class
     * @param context
     */
    @Autowired
    //@Qualifier("getterGreetingService")
    private GreetingService greetingService;



    private GreetingService greetingService1;

    // check for qulifier SimpleControllerQuailifier(@Qualifier("greetingServiceImpl") GreetingService greetingService1){
    SimpleControllerQuailifier( GreetingService greetingService1){
        System.out.println("Hello");
    }

    public void callSayHello(){
        greetingService1.sayHello();
    }

    public  static void testBean(ConfigurableApplicationContext context){

        SimpleControllerQuailifier d = (SimpleControllerQuailifier) context.getBean("simpleControllerQuailifier");
        GreetingService d2= (GreetingService) context.getBean(GreetingService.class);
        GreetingService d3= (GreetingService) context.getBean(GreetingService.class);

        d2.sayHello();
        d3.sayHello();


    }

}

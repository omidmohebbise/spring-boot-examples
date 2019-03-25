package omid.spring.example.springexample.actuator;

import omid.spring.example.springexample.rabitmq.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
 //after add security library then it is need to use security configuration.
//@ComponentScan("omid.spring.example.springexample.security")
public class RunSpring {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunSpring.class);


    public  static   void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext contex =  SpringApplication.run(RunSpring.class, args);
    }

    @RestController("hello")
    public class SimpleRest{

        @RequestMapping("/test1")
        public String getSth(){
            return "hello test1";
        }
    }

}

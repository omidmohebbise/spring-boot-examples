package omid.spring.example.springexample.callrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SimpleRestConsumer {

    @RequestMapping("/callperson")
    public Person getPerson(){
       Person persons= null;
        RestTemplate restTemplate = new RestTemplate();
        persons = restTemplate.getForObject("http://127.0.0.1:8086/getperson", Person.class);
        return persons;
    }

    @RequestMapping("/callpersons")
    public List<Person> getPersons(){
        List<Person>  persons= new ArrayList<Person>();
        RestTemplate restTemplate = new RestTemplate();
        persons = restTemplate.getForObject("http://127.0.0.1:8086/getpersons", List.class);
        return persons;
    }
}

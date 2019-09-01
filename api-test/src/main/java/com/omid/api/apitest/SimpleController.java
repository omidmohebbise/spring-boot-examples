package com.omid.api.apitest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    @ResponseBody
    @PostMapping("/hellopost")
    public ResponseEntity<Person> store(@RequestBody Person p) {
        p.setName(p.getName()+"Faaaaaaa");
        try {
            return ResponseEntity.status( HttpStatus.CREATED).body(p);
        } catch (Exception e) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreateCredentialViewModel(null, e.getMessage()));
            System.out.println("Error ...........................");
            return null;
        }
    }

    /*@PostMapping("/hellopost")
    public Person getHelloPost(@RequestBody Person p){
        System.out.println("Hello From post method");
        System.out.println(p.name);
        System.out.println(p.family);
        return p;
    }*/
    @GetMapping("/hello2")
    public Object getPerson2(){
        System.out.println("Helooooo");

        Person1 person1= new Person1("omid1", "mohebbi");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person1> responseEntity = null;
        try {
            responseEntity = restTemplate.postForEntity("http://127.0.0.1:7171/hellopost", person1, Person1.class);
            System.out.println("Response:" + responseEntity.getBody().toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        return person1;
    }

   /* @GetMapping("/hello")
   public Object getPerson(){
        System.out.println("Helo");

            class Person1{
                String name;
                String family;

                public Person1() {
                }

                public Person1(String name, String family) {
                    this.name = name;
                    this.family = family;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFamily() {
                    return family;
                }

                public void setFamily(String family) {
                    this.family = family;
                }
            }

            Person1 persons= new Person1("omid1", "mohebbi");
            RestTemplate restTemplate = new RestTemplate();
            Object obj  = restTemplate.postForObject("http://127.0.0.1:7171/hellopost" , persons,Object.class);
            return persons;
    }*/

  /*  @GetMapping("/hello1")
    public Person getPerson1(){
        System.out.println("Helo");
        Person persons= new Person("omid", "mohebbi");
        RestTemplate restTemplate = new RestTemplate();
        persons = restTemplate.getForObject("http://127.0.0.1:7171/hellorest" , Person.class);
        return persons;
    }

    @GetMapping("/hellorest")
    public Person getHelloRest(){
        Person p = new Person("omid", "mohebbi");
        System.out.println(p.name);
        System.out.println(p.family);
        return p;
    }*/
 }

package com.omidmohebbise.webflox.client;

import com.omidmohebbise.webflox.model.Employee;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class EmployeeWebClient {
    WebClient client = WebClient.create("http://localhost:9192");

    //@Scheduled(fixedRate = 5_000)
    public void timeout1(){


        Mono<Employee> employeeMono = client.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);
        employeeMono.subscribe(System.out::println);


    }
    @Scheduled(fixedRate = 60_000)
    public void timeout2(){
        //System.out.println("10************");
        Flux<Employee> employeeFlux = client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);
        //employeeFlux.subscribe(System.out::println);
        //System.out.println("**************");
    }



}

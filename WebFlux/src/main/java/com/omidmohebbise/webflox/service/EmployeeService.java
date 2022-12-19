package com.omidmohebbise.webflox.service;

import com.omidmohebbise.webflox.model.Employee;
import com.omidmohebbise.webflox.model.repository.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Mono<Employee> findById(long id) {
        return repository.findById(id);
    }

    public Flux<Employee> findAll() {
        return repository.findAll();
    }

    @Scheduled(fixedRate = 1000)
    private void execute() {
        var result = repository.count();
        var counter = result.block();
        var r = repository.save(new Employee(counter, "name family" + counter, counter * 100));
        System.out.println(r.block());
    }

}

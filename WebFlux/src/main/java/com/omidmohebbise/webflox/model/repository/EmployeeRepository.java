package com.omidmohebbise.webflox.model.repository;

import com.omidmohebbise.webflox.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee , Long> {
}

package com.spdeveloper.mockitostarter.persistence;

import com.spdeveloper.mockitostarter.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person,Long> {
}

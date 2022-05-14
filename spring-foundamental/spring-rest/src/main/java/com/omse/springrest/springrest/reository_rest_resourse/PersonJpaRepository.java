package com.omse.springrest.springrest.reository_rest_resourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person , Long> {
}

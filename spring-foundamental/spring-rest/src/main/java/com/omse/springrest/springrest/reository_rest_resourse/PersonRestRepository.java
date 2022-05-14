package com.omse.springrest.springrest.reository_rest_resourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "persons",collectionResourceRel = "persons")
public interface PersonRestRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);

}

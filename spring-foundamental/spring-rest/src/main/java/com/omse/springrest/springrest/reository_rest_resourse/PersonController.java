package com.omse.springrest.springrest.reository_rest_resourse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public ResponseEntity<?> findALl(){
        return ResponseEntity.ok().body(personService.findAll());
    }
}

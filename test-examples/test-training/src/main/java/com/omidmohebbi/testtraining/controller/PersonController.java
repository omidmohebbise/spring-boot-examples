package com.omidmohebbi.testtraining.controller;


import com.omidmohebbi.testtraining.service.AddPerson;
import com.omidmohebbi.testtraining.service.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private AddPerson addPerson;

    public PersonController(AddPerson addPerson) {
        this.addPerson = addPerson;
    }

    @PostMapping
    public ResponseEntity<?> addPerson(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(addPerson.execute(personDto));
    }
}

package com.omidmohebbise.kotlin.controller

import com.omidmohebbise.kotlin.domain.Person
import com.omidmohebbise.kotlin.repository.PersonRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    val personRepository: PersonRepository

    constructor(personRepository: PersonRepository) {
        this.personRepository = personRepository
    }

    @GetMapping("/find-all")
    fun findAll(): ResponseEntity<List<Person>> {

        return ResponseEntity.ok().body(personRepository.findAll())
    }
    @GetMapping("/add")
    fun add(): ResponseEntity<Person> {

        return ResponseEntity.ok().body(personRepository.save(Person( "Omid Mohebbi")))
    }
}
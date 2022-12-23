package com.omidmohebbise.kotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @GetMapping("/find-all")
    fun findAll(): ResponseEntity<List<String>> {
        val names = listOf("Volvo", "BMW", "Ford", "Mazda")
        return ResponseEntity.ok().body(names)
    }
}
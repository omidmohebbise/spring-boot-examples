package com.omidmohebbise.kotlin.domain

import javax.persistence.*

@Table(name = "persons")
@Entity
class Person {
    @Id @GeneratedValue var id: Long? = null
    var fullName: String = ""


    constructor(fullName: String) {
        this.fullName = fullName
    }
    constructor(){

    }
}
package com.omidmohebbise.kotlin.repository

import com.omidmohebbise.kotlin.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person,Long>{
}
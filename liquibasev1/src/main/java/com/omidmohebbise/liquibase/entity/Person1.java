package com.omidmohebbise.liquibase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Persons1" ,schema = "dbo")
@Data
@NoArgsConstructor
public class Person1 {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
}

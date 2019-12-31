package com.example.omid.aspect.aspect.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Person {
    @Id
    public Long id;
    public String name;
    public String family;
}

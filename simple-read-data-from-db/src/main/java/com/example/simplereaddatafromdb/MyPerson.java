package com.example.simplereaddatafromdb;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Table(name = "AAAPerson")
@Setter
public class MyPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long id;

    @NotNull
    public String name;
    public String family;


    public MyPerson(){

    }


}

package com.example.simplereaddatafromdb;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "AAPerson")
@Setter
public class MyPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long id;

    @Long(6)
    @NotNull
    public String name;
    public String family;


    public MyPerson(){

    }


}

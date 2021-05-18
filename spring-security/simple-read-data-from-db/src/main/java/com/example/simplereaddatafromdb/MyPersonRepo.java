package com.example.simplereaddatafromdb;


import org.springframework.data.repository.CrudRepository;

public interface MyPersonRepo extends CrudRepository<MyPerson , Long> {
    //public MyPerson findByEmail(String email);


}

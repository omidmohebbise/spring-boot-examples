package com.example.simplereaddatafromdb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;

@RestController
public class ReadDataController {

    public MyPersonRepo myPersonRepo;

    public ReadDataController(MyPersonRepo myPersonRepo) {
        this.myPersonRepo = myPersonRepo;
    }

    @RequestMapping("/readdata")
    public List<MyPerson> readData(){
      MyPerson  myPerson = new MyPerson();
      myPerson.family="mohebbi";
      myPerson.name = "omid";
      myPersonRepo.save(myPerson);

      List<MyPerson> list  = (List<MyPerson>) myPersonRepo.findAll();

        return list;
    }
}

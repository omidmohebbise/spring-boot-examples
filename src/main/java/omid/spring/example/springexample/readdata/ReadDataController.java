package omid.spring.example.springexample.readdata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadDataController {

    public MyPersonRepo myPersonRepo;

    public ReadDataController(MyPersonRepo myPersonRepo) {
        this.myPersonRepo = myPersonRepo;
    }

    @RequestMapping("/readdata")
    public String readData(){
        MyPerson myPerson = new MyPerson();
        myPerson.setName("omid");
        myPerson.setFamily("mohebbi");
        myPersonRepo.save(myPerson);



        return "hello world";
    }
}

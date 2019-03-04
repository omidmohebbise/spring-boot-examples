package omid.spring.example.springexample.readdata;


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

    public String name;
    public String family;


    public MyPerson(){

    }


}

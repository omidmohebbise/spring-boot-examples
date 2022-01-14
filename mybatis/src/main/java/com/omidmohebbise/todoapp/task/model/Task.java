package com.omidmohebbise.todoapp.task.model;

import com.omidmohebbise.todoapp.identity.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Entity
//@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

  //  @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    //@ManyToOne
    private long userId;

    private Date doDate;
    private boolean done;


}

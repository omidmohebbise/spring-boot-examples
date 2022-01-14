package com.omidmohebbise.todoapp.task.model;

import com.omidmohebbise.todoapp.identity.model.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToOne
    private UserEntity user;

    private Date doDate;
    private boolean done;


}

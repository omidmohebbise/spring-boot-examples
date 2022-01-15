package com.omidmohebbise.todoapp.task.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class Task {
    private long id;
    private String title;
    private long userId;
    private Date doDate;
    private boolean done;

}
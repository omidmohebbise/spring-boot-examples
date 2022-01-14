package com.omidmohebbise.todoapp.task.usecase.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDmlDto {
    private String title;
    private Date doDate;
    private boolean done;
}

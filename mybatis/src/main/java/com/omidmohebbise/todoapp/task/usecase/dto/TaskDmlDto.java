package com.omidmohebbise.todoapp.task.usecase.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TaskDmlDto {

    @NotNull(message = "Title may not be null.")
    @Length(min = 3, message = "Title may not be empty.")
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssssZ")
    private Date doDate;
    private boolean done;
}

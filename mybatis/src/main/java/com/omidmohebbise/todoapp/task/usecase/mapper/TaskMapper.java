package com.omidmohebbise.todoapp.task.usecase.mapper;

import com.omidmohebbise.todoapp.task.model.Task;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static List<TaskDto> mapToDto(List<Task> taskEntities){
        return taskEntities.stream().map(taskEntity -> TaskDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .doDate(taskEntity.getDoDate())
                .done(taskEntity.isDone())
                .build()).collect(Collectors.toList());

    }
}

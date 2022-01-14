package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.task.model.TaskEntity;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDmlDto;
import org.springframework.stereotype.Service;

@Service
public class EditTaskUC {
    private final TaskRepository taskRepository;
    private FindTaskUC findTaskUC;

    public EditTaskUC(TaskRepository taskRepository, FindTaskUC findTaskUC) {
        this.taskRepository = taskRepository;
        this.findTaskUC = findTaskUC;
    }


    public long execute(long id, TaskDmlDto taskDto)
    {
        TaskEntity taskEntity = findTaskUC.findByIdAndCurrentUserId(id);
        taskEntity.setTitle(taskDto.getTitle());
        taskEntity.setDoDate(taskDto.getDoDate());
        return taskRepository.save(taskEntity).getId();

    }


}

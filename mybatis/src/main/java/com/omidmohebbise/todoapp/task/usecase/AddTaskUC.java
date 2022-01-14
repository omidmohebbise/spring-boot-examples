package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.identity.usecase.GetCurrentUserUC;
import com.omidmohebbise.todoapp.task.model.TaskEntity;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDmlDto;
import org.springframework.stereotype.Service;

@Service
public class AddTaskUC {
    private final GetCurrentUserUC getCurrentUserUC;
    private final TaskRepository taskRepository;

    public AddTaskUC(GetCurrentUserUC getCurrentUserUC, TaskRepository taskRepository) {
        this.getCurrentUserUC = getCurrentUserUC;
        this.taskRepository = taskRepository;
    }

    public long execute(TaskDmlDto taskDto)
    {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskDto.getTitle());
        taskEntity.setDoDate(taskDto.getDoDate());
        taskEntity.setUser(getCurrentUserUC.execute());
        return taskRepository.save(taskEntity).getId();

    }
}

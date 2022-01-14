package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.identity.usecase.GetCurrentUserUC;
import com.omidmohebbise.todoapp.task.model.Task;
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

    public long execute(TaskDmlDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDoDate(taskDto.getDoDate());
        task.setUserId(getCurrentUserUC.execute().getId());
        return taskRepository.insert(task);

    }
}

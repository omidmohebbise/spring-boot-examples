package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.task.model.Task;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDmlDto;
import org.springframework.stereotype.Service;

@Service
public class EditTaskUC {
    private final TaskRepository taskRepository;
    private final FindTaskUC findTaskUC;

    public EditTaskUC(TaskRepository taskRepository, FindTaskUC findTaskUC) {
        this.taskRepository = taskRepository;
        this.findTaskUC = findTaskUC;
    }


    public void execute(long id, TaskDmlDto taskDto) {
        Task task = findTaskUC.findByIdAndCurrentUserId(id);
        task.setTitle(taskDto.getTitle());
        task.setDoDate(taskDto.getDoDate());
        taskRepository.update(task);
    }
}

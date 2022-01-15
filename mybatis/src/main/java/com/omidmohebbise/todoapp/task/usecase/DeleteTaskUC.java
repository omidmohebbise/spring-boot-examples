package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUC {

    private final TaskRepository taskRepository;
    private final FindTaskUC findTaskUC;

    public DeleteTaskUC(TaskRepository taskRepository, FindTaskUC findTaskUC) {
        this.taskRepository = taskRepository;
        this.findTaskUC = findTaskUC;
    }

    public void execute(long taskId) {
        taskRepository.delete(findTaskUC.findByIdAndCurrentUserId(taskId));
    }
}

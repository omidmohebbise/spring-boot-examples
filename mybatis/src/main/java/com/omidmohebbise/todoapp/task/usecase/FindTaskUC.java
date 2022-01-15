package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.identity.usecase.GetCurrentUserUC;
import com.omidmohebbise.todoapp.task.model.Task;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDto;
import com.omidmohebbise.todoapp.task.usecase.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindTaskUC {
    private final TaskRepository taskRepository;
    private final GetCurrentUserUC getCurrentUserUC;

    public FindTaskUC(TaskRepository taskRepository, GetCurrentUserUC getCurrentUserUC) {
        this.taskRepository = taskRepository;
        this.getCurrentUserUC = getCurrentUserUC;
    }

    public Task findByIdAndCurrentUserId(long id) {
        return taskRepository.findByIdAndUserId(id, getCurrentUserUC.execute().getId()).orElseThrow(() ->
                new RuntimeException("The task not found."));
    }

    public List<Task> findAllEntities(int page, int size) {
        return taskRepository.findAll(page, size , getCurrentUserUC.execute().getId());
    }

    public List<TaskDto> findAllTask(int page, int size) {
        return TaskMapper.mapToDto(findAllEntities(page, size));
    }
}

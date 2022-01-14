package com.omidmohebbise.todoapp.task.model.repository;

import com.omidmohebbise.todoapp.task.model.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    TaskEntity save(TaskEntity taskEntity);

    Optional<TaskEntity> findById(long id);
    Optional<TaskEntity> findByIdAndUserId(long id, long userId);
    List<TaskEntity> findAll(int page, int size);
    void delete(TaskEntity byIdAndCurrentUserId);
}

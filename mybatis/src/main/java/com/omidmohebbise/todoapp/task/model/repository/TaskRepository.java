package com.omidmohebbise.todoapp.task.model.repository;

import com.omidmohebbise.todoapp.task.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    long insert(Task task);

    void update(Task task);

    Optional<Task> findByIdAndUserId(long id, long userId);

    List<Task> findAll(int page, int size, long userId);

    void delete(Task byIdAndCurrentUserId);
}

package com.omidmohebbise.todoapp.task.model.repository.impl;

import com.omidmohebbise.todoapp.task.model.Task;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskMapper taskMapper;

    public TaskRepositoryImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public long insert(Task task) {
        taskMapper.insert(task);
        return task.getId();
    }

    @Override
    public void update(Task task) {
        taskMapper.update(task);
    }

    @Override
    public Optional<Task> findByIdAndUserId(long id, long userId) {
        return Optional.ofNullable(taskMapper.findByIdAndUserId(id, userId));
    }

    @Override
    public List<Task> findAll(int page, int size , long userId) {
        return taskMapper.findAll(page, size,userId);
    }

    @Override
    public void delete(Task task) {
        taskMapper.delete(task);
    }
}

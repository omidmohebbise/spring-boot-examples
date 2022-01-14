package com.omidmohebbise.todoapp.task.model.repository.impl;

import com.omidmohebbise.todoapp.task.model.TaskEntity;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskRepositoryImpl implements TaskRepository {
    private TaskJpaRepository taskJpaRepository;

    public TaskRepositoryImpl(TaskJpaRepository taskJpaRepository) {
        this.taskJpaRepository = taskJpaRepository;
    }


    @Override
    public TaskEntity save(TaskEntity taskEntity) {
        return taskJpaRepository.save(taskEntity);
    }

    @Override
    public Optional<TaskEntity> findById(long id) {
        return taskJpaRepository.findById(id);
    }

    @Override
    public Optional<TaskEntity> findByIdAndUserId(long id, long userId) {
        return taskJpaRepository.findByIdAndUserId(id, userId);
    }

    @Override
    public List<TaskEntity> findAll(int page, int size) {
        return taskJpaRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public void delete(TaskEntity taskEntity) {
        taskJpaRepository.delete(taskEntity);
    }
}

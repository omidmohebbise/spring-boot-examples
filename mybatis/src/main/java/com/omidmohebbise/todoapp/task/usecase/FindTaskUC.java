package com.omidmohebbise.todoapp.task.usecase;

import com.omidmohebbise.todoapp.identity.usecase.GetCurrentUserUC;
import com.omidmohebbise.todoapp.task.model.TaskEntity;
import com.omidmohebbise.todoapp.task.model.repository.TaskRepository;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDmlDto;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDto;
import com.omidmohebbise.todoapp.task.usecase.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FindTaskUC {
    private TaskRepository taskRepository;
    private GetCurrentUserUC getCurrentUserUC;

    public FindTaskUC(TaskRepository taskRepository, GetCurrentUserUC getCurrentUserUC) {
        this.taskRepository = taskRepository;
        this.getCurrentUserUC = getCurrentUserUC;
    }

    public TaskEntity findByIdAndCurrentUserId(long id){
        return taskRepository.findByIdAndUserId(id,getCurrentUserUC.execute().getId()).orElseThrow(()-> new EntityNotFoundException("Task not found."));
    }

    public List<TaskEntity> findAllEntities(int page , int size){
        return taskRepository.findAll(page,size);
    }

    public List<TaskDto> findAllTask(int page, int size){
        return TaskMapper.mapToDto(findAllEntities(page,size));
    }
}

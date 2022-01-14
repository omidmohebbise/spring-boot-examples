package com.omidmohebbise.todoapp.task.model.repository;

import com.omidmohebbise.todoapp.task.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity,Long> , PagingAndSortingRepository<TaskEntity,Long> {
    Optional<TaskEntity> findByIdAndUserId(long id, long userId);
}

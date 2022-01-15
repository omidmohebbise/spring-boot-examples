package com.omidmohebbise.todoapp.task.controller;

import com.omidmohebbise.todoapp.task.usecase.AddTaskUC;
import com.omidmohebbise.todoapp.task.usecase.DeleteTaskUC;
import com.omidmohebbise.todoapp.task.usecase.EditTaskUC;
import com.omidmohebbise.todoapp.task.usecase.FindTaskUC;
import com.omidmohebbise.todoapp.task.usecase.dto.TaskDmlDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

public class TaskController {

    private final AddTaskUC addTaskUC;
    private final EditTaskUC editTaskUC;
    private final DeleteTaskUC deleteTaskUC;
    private final FindTaskUC findTaskUC;

    public TaskController(AddTaskUC addTaskUC, EditTaskUC editTaskUC, DeleteTaskUC deleteTaskUC, FindTaskUC findTaskUC) {
        this.addTaskUC = addTaskUC;
        this.editTaskUC = editTaskUC;
        this.deleteTaskUC = deleteTaskUC;
        this.findTaskUC = findTaskUC;
    }


    @PostMapping(path = "/tasks/add")
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskDmlDto taskDto) {
        return ResponseEntity.ok().body(addTaskUC.execute(taskDto));
    }

    @PutMapping(path = "/tasks/edit/{id}")
    public ResponseEntity<?> editTask(@PathVariable long id, @Valid @RequestBody TaskDmlDto taskDto) {
        editTaskUC.execute(id, taskDto);
        return ResponseEntity.ok().body("");
    }

    @DeleteMapping(path = "/tasks/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable long id) {
        deleteTaskUC.execute(id);
        return ResponseEntity.ok().body("");
    }

    @GetMapping(path = "/tasks/all/{page}/{size}")
    public ResponseEntity<?> findAll(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok().body(findTaskUC.findAllTask(page, size));
    }

}

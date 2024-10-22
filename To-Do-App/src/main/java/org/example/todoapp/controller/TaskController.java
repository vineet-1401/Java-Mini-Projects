package org.example.todoapp.controller;

import org.apache.coyote.Response;
import org.example.todoapp.entity.Task;
import org.example.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/get-all-task")
    public ResponseEntity<List<Task>> getALlTask(){
        List<Task> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/get-task/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id){
        Task task = taskService.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/add-task")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        taskService.addTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id){
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task updatedTask = taskService.updateTask(task.getTaskId(), task.getTitle());
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @PutMapping("/update-status")
    public ResponseEntity<Task> updateStatus(@RequestBody Task task){
        Task updatedTask = taskService.updateStatus(task.getTaskId());
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }


}

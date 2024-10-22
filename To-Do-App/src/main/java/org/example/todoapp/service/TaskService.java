package org.example.todoapp.service;

import org.example.todoapp.entity.Task;
import org.example.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task findTaskById(int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()) {
            return optionalTask.get();
        }else{
            throw new RuntimeException("Task not found");
        }

    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(int taskId, String title) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(title);

            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found with id: " + taskId);
        }
    }

    public Task updateStatus(Integer taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        // Toggle the status
        Task task = optionalTask.get();
        System.out.println(task.getStatus() + " " + task.getTitle());
        task.setTitle("Vineet");
        task.setStatus(true); // Toggling the status
        return taskRepository.save(task);
    }


}

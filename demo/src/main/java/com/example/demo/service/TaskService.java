package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {


        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        // Logique pour mettre à jour une tâche
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    @Transactional
    public void resetDatabase() {
            taskRepository.deleteAll();
            entityManager.flush();
            entityManager.createNativeQuery("ALTER TABLE task AUTO_INCREMENT = 1").executeUpdate();
    }

}

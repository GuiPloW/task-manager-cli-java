package br.com.guilherme.taskmanager.service;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private final TaskRepository repository;
    private Long nextId = 1L;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String title, String description) {
        Task task = new Task(nextId, title, description);

        repository.save(task);
        nextId++;

        return task;
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }

    public void updateTask(Long id, String newTitle, String newDescription) {
        Task task = repository.findById(id);

        task.setTitle(newTitle);
        task.setDescription(newDescription);
    }

    public void completeTask(Long id) {
        Task task = repository.findById(id);
        task.markAsCompleted();
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}

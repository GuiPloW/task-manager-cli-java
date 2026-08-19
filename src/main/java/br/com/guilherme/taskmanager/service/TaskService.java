package br.com.guilherme.taskmanager.service;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.repository.TaskRepository;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void updateTask(Long id, String newTitle, String newDescription) {
        Task task = repository.findById(id);

        task.setTitle(newTitle);
        task.setDescription(newDescription);
    }
}

package br.com.guilherme.taskmanager.service;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import br.com.guilherme.taskmanager.exception.ValidationException;

import java.util.List;

public class TaskService {

    private final TaskRepository repository;
    private Long nextId;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
        this.nextId = calculateNextId();
    }

    public Task createTask(String title, String description) {

        validateTitle(title);

        Task task = new Task(
                nextId,
                title.trim(),
                description.trim()
        );

        repository.save(task);

        nextId++;

        return task;
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }

    public void updateTask(
            Long id,
            String newTitle,
            String newDescription
    ) {

        validateTitle(newTitle);

        Task task = repository.findById(id);

        task.setTitle(newTitle.trim());
        task.setDescription(newDescription.trim());

        repository.update();
    }

    public void completeTask(Long id) {

        Task task = repository.findById(id);

        task.markAsCompleted();

        repository.update();
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    private void validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new ValidationException(
                    "O título da tarefa não pode estar vazio."
            );
        }
    }

    private Long calculateNextId() {

        return repository.findAll()
                .stream()
                .mapToLong(Task::getId)
                .max()
                .orElse(0L) + 1;
    }
}
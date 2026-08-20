package br.com.guilherme.taskmanager.repository;

import br.com.guilherme.taskmanager.exception.TaskNotFoundException;
import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.persistence.JsonTaskStorage;

import java.util.List;

public class TaskRepository {

    private final List<Task> tasks;
    private final JsonTaskStorage storage;

    public TaskRepository() {
        this.storage = new JsonTaskStorage();
        this.tasks = storage.load();
    }

    public void save(Task task) {
        tasks.add(task);
        storage.save(tasks);
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        throw new TaskNotFoundException(id);
    }

    public void update() {
        storage.save(tasks);
    }

    public void deleteById(Long id) {
        Task task = findById(id);

        tasks.remove(task);
        storage.save(tasks);
    }
}
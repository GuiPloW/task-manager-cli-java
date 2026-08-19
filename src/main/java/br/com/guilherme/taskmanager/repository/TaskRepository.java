package br.com.guilherme.taskmanager.repository;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.exception.TaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public void save(Task task) {
        tasks.add(task);
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Long id) {

        for(Task task : tasks) {
            if(task.getId().equals(id)) {
                return task;
            }
        }
        throw new TaskNotFoundException(id);
    }
}

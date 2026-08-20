package br.com.guilherme.taskmanager.persistence;

import br.com.guilherme.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MemoryTaskStorage implements TaskStorage {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public void save(List<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    @Override
    public List<Task> load() {
        return new ArrayList<>(tasks);
    }
}
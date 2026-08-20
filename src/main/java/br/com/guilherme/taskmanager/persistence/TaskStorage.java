package br.com.guilherme.taskmanager.persistence;

import br.com.guilherme.taskmanager.model.Task;

import java.util.List;

public interface TaskStorage {

    void save(List<Task> tasks);

    List<Task> load();
}
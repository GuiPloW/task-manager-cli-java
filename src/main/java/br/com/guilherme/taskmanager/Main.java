package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.persistence.JsonTaskStorage;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import br.com.guilherme.taskmanager.service.TaskService;
import br.com.guilherme.taskmanager.ui.TaskMenu;

public class Main {

    public static void main(String[] args) {

        TaskRepository repository =
                new TaskRepository(new JsonTaskStorage());

        TaskService service = new TaskService(repository);

        TaskMenu menu = new TaskMenu(service);

        menu.start();
    }
}
package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.service.TaskService;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import br.com.guilherme.taskmanager.exception.TaskNotFoundException;

public class Main {

    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        service.createTask(
                "Estudar Java",
                "Revisar conceitos de POO"
        );

        service.createTask(
                "Fazer projeto",
                "Continuar o gerenciador de tarefas"
        );

        for (Task task : repository.findAll()) {
            System.out.println(
                    task.getId() + " - " + task.getTitle()
            );
        }

//        for (Task task : repository.findAll()) {
//            System.out.println(task.getId() + " - " + task.getTitle());
//        }


//        try {
//            Task foundTask = repository.findById(999L);
//
//            System.out.println("Tarefa encontrada: " + foundTask.getTitle());
//
//        } catch (TaskNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
    }
}

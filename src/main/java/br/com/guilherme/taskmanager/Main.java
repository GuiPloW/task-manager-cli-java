package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.repository.TaskRepository;

public class Main {

    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();

        Task task1 = new Task(
                1L,
                "Estudar Java",
                "Revisar POO"
        );

        Task task2 = new Task(
                2L,
                "Fazer projeto",
                "Continuar o gerenciador de tarefas"
        );

        repository.save(task1);
        repository.save(task2);

        for (Task task : repository.findAll()) {
            System.out.println(
                    task.getId() + " - "
                            + task.getTitle()
            );
        }
    }
}

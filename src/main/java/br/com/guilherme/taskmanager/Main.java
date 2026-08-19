package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.service.TaskService;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import br.com.guilherme.taskmanager.exception.TaskNotFoundException;

public class Main {

    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

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

        repository.deleteById(1L);

        service.updateTask(
                2L,
                "Finalizar projeto Java",
                "Terminar o gerenciador de tarefas CLI"
        );

        Task updatedTask = repository.findById(2L);

        System.out.println(updatedTask.getTitle());
        System.out.println(updatedTask.getDescription());

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

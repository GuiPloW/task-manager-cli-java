package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.exception.TaskNotFoundException;
import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import br.com.guilherme.taskmanager.service.TaskService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Concluir tarefa");
            System.out.println("5 - Excluir tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção numérica válida.");
                continue;
            }

            switch (option) {

                case 1:
                    System.out.print("Título da tarefa: ");
                    String title = scanner.nextLine();

                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();

                    service.createTask(title, description);

                    System.out.println("Tarefa criada com sucesso!");
                    break;

                case 2:
                    if (service.listTasks().isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                        break;
                    }

                    System.out.println("\n===== TAREFAS =====");

                    for (Task task : service.listTasks()) {

                        String status = task.isCompleted()
                                ? "[X]"
                                : "[ ]";

                        System.out.println(
                                status
                                        + " #" + task.getId()
                                        + " - " + task.getTitle()
                        );

                        System.out.println(
                                "    " + task.getDescription()
                        );
                    }

                    break;

                case 3:
                    Long editId = readLong(
                            scanner,
                            "Digite o ID da tarefa que deseja editar: "
                    );

                    System.out.print("Novo título: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Nova descrição: ");
                    String newDescription = scanner.nextLine();

                    try {
                        service.updateTask(
                                editId,
                                newTitle,
                                newDescription
                        );

                        System.out.println(
                                "Tarefa atualizada com sucesso!"
                        );

                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 4:
                    Long id = readLong(
                            scanner,
                            "Digite o ID da tarefa que deseja concluir: "
                    );

                    try {
                        service.completeTask(id);

                        System.out.println(
                                "Tarefa concluída com sucesso!"
                        );

                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:
                    Long deleteId = readLong(
                            scanner,
                            "Digite o ID da tarefa que deseja excluir: "
                    );

                    try {
                        service.deleteTask(deleteId);

                        System.out.println(
                                "Tarefa excluída com sucesso!"
                        );

                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (option != 0);

        scanner.close();

        System.out.println("Programa encerrado.");
    }

    private static Long readLong(
            Scanner scanner,
            String message
    ) {

        while (true) {
            System.out.print(message);

            try {
                return Long.parseLong(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}
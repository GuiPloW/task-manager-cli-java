package br.com.guilherme.taskmanager.ui;

import br.com.guilherme.taskmanager.exception.StorageException;
import br.com.guilherme.taskmanager.exception.TaskNotFoundException;
import br.com.guilherme.taskmanager.exception.ValidationException;
import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.service.TaskService;

import java.util.Scanner;

public class TaskMenu {

    private final TaskService service;
    private final Scanner scanner;

    public TaskMenu(TaskService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        int option = -1;

        do {
            showMenu();

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção numérica válida.");
                continue;
            }

            try {
                switch (option) {

                    case 1:
                        createTask();
                        break;

                    case 2:
                        listTasks();
                        break;

                    case 3:
                        updateTask();
                        break;

                    case 4:
                        completeTask();
                        break;

                    case 5:
                        deleteTask();
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (StorageException e) {
                System.out.println(
                        "Erro ao acessar os dados: " + e.getMessage()
                );

            } catch (ValidationException e) {
                System.out.println(
                        "Dados inválidos: " + e.getMessage()
                );
            }

        } while (option != 0);

        scanner.close();

        System.out.println("Programa encerrado.");
    }

    private void showMenu() {
        System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Editar tarefa");
        System.out.println("4 - Concluir tarefa");
        System.out.println("5 - Excluir tarefa");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void createTask() {
        System.out.print("Título da tarefa: ");
        String title = scanner.nextLine();

        System.out.print("Descrição da tarefa: ");
        String description = scanner.nextLine();

        service.createTask(title, description);

        System.out.println("Tarefa criada com sucesso!");
    }

    private void listTasks() {

        if (service.listTasks().isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
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
    }

    private void updateTask() {

        Long id = readLong(
                "Digite o ID da tarefa que deseja editar: "
        );

        System.out.print("Novo título: ");
        String newTitle = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String newDescription = scanner.nextLine();

        try {
            service.updateTask(
                    id,
                    newTitle,
                    newDescription
            );

            System.out.println(
                    "Tarefa atualizada com sucesso!"
            );

        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void completeTask() {

        Long id = readLong(
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
    }

    private void deleteTask() {

        Long id = readLong(
                "Digite o ID da tarefa que deseja excluir: "
        );

        try {
            service.deleteTask(id);

            System.out.println(
                    "Tarefa excluída com sucesso!"
            );

        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Long readLong(String message) {

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
package br.com.guilherme.taskmanager;

import br.com.guilherme.taskmanager.model.Task;

public class Main {

    public static void main(String[] args) {
        Task task = new Task(
                1L,
                "estudar java",
                "revisar conceitos de POO"
        );

        System.out.println("Titulo: " + task.getTitle());
        System.out.println("Descricao: " + task.getDescription());
        System.out.println("Concluida: " + task.isCompleted());

        task.markAsCompleted();

        System.out.println("Concluida depois da alteracao: " + task.isCompleted());
    }
}

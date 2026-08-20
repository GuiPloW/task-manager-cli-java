package br.com.guilherme.taskmanager.service;

import br.com.guilherme.taskmanager.exception.TaskNotFoundException;
import br.com.guilherme.taskmanager.exception.ValidationException;
import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.persistence.MemoryTaskStorage;
import br.com.guilherme.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        TaskRepository repository =
                new TaskRepository(new MemoryTaskStorage());

        service = new TaskService(repository);
    }

    @Test
    void shouldCreateTask() {

        Task task = service.createTask(
                "Estudar Java",
                "Revisar JUnit"
        );

        assertEquals(1L, task.getId());
        assertEquals("Estudar Java", task.getTitle());
        assertEquals("Revisar JUnit", task.getDescription());
        assertFalse(task.isCompleted());
    }

    @Test
    void shouldNotCreateTaskWithEmptyTitle() {

        assertThrows(
                ValidationException.class,
                () -> service.createTask("", "Descrição")
        );
    }

    @Test
    void shouldListTasks() {

        service.createTask("Tarefa 1", "Descrição 1");
        service.createTask("Tarefa 2", "Descrição 2");

        List<Task> tasks = service.listTasks();

        assertEquals(2, tasks.size());
    }

    @Test
    void shouldUpdateTask() {

        Task task = service.createTask(
                "Título antigo",
                "Descrição antiga"
        );

        service.updateTask(
                task.getId(),
                "Título novo",
                "Descrição nova"
        );

        assertEquals("Título novo", task.getTitle());
        assertEquals("Descrição nova", task.getDescription());
    }

    @Test
    void shouldCompleteTask() {

        Task task = service.createTask(
                "Estudar Java",
                "Estudar testes"
        );

        service.completeTask(task.getId());

        assertTrue(task.isCompleted());
    }

    @Test
    void shouldDeleteTask() {

        Task task = service.createTask(
                "Tarefa",
                "Descrição"
        );

        service.deleteTask(task.getId());

        assertTrue(service.listTasks().isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenTaskDoesNotExist() {

        assertThrows(
                TaskNotFoundException.class,
                () -> service.completeTask(999L)
        );
    }
}
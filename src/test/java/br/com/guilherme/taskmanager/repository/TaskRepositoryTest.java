package br.com.guilherme.taskmanager.repository;

import br.com.guilherme.taskmanager.exception.TaskNotFoundException;
import br.com.guilherme.taskmanager.model.Task;
import br.com.guilherme.taskmanager.persistence.MemoryTaskStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskRepositoryTest {

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository(
                new MemoryTaskStorage()
        );
    }

    @Test
    void shouldSaveTask() {

        Task task = new Task(
                1L,
                "Estudar Java",
                "Revisar POO"
        );

        repository.save(task);

        List<Task> tasks = repository.findAll();

        assertEquals(1, tasks.size());
        assertEquals(task, tasks.getFirst());
    }

    @Test
    void shouldFindTaskById() {

        Task task = new Task(
                1L,
                "Estudar Java",
                "Revisar POO"
        );

        repository.save(task);

        Task foundTask = repository.findById(1L);

        assertEquals(task, foundTask);
    }

    @Test
    void shouldThrowExceptionWhenTaskDoesNotExist() {

        assertThrows(
                TaskNotFoundException.class,
                () -> repository.findById(999L)
        );
    }

    @Test
    void shouldDeleteTask() {

        Task task = new Task(
                1L,
                "Estudar Java",
                "Revisar POO"
        );

        repository.save(task);

        repository.deleteById(1L);

        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void shouldListAllTasks() {

        repository.save(
                new Task(1L, "Tarefa 1", "Descrição 1")
        );

        repository.save(
                new Task(2L, "Tarefa 2", "Descrição 2")
        );

        List<Task> tasks = repository.findAll();

        assertEquals(2, tasks.size());
    }
}
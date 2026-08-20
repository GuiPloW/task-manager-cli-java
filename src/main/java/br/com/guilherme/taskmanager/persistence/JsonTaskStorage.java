package br.com.guilherme.taskmanager.persistence;

import br.com.guilherme.taskmanager.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTaskStorage {

    private final ObjectMapper objectMapper;
    private final File file;

    public JsonTaskStorage() {
        this.objectMapper = new ObjectMapper();
        this.file = new File("tasks.json");
    }

    public void save(List<Task> tasks) {
        try {
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(file, tasks);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao salvar as tarefas.",
                    e
            );
        }
    }

    public List<Task> load() {

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    file,
                    new TypeReference<List<Task>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao carregar as tarefas.",
                    e
            );
        }
    }
}
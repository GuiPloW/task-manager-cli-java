package br.com.guilherme.taskmanager.model;

public class Task {

    private Long id;
    private String title;
    private String description;
    private Boolean completed;

    // Construtor vazio para o Jackson
    public Task() {
    }

    // Construtor que já tínhamos
    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isCompleted() {
        return completed;
    }

    // NOVO
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // NOVO
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void markAsPending() {
        this.completed = false;
    }
}
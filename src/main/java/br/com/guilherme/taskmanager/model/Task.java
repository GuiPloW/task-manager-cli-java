package br.com.guilherme.taskmanager.model;

public class Task {

    private Long id;
    private String title;
    private String description;
    private Boolean completed;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public void markAsPending() {
        this.completed = false;
    }
}

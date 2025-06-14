package org.example;

import java.time.LocalDateTime;

public class Task {
    private static int taskIDS = 1;
    private int id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Task(){}
    Task(String description){
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.id = taskIDS;
        taskIDS++;
    }

    public static int getTaskIDS(){return taskIDS;}
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Status getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


}

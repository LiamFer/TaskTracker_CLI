package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TasksDB {
    private static ArrayList<Task> tasks;

    TasksDB() {
    }

    public static void connectDatabase() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        File file = new File("tarefas.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
                mapper.writeValue(file, mapper.createArrayNode());
                System.out.println("Arquivo tarefas.json criado!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tasks = mapper.readValue(file, new TypeReference<ArrayList<Task>>() {
        });
    }

    public static void addTask(String description) {
        int id = 1;
        if (!tasks.isEmpty()) {
            id = tasks.getLast().getId() + 1;
        }
        tasks.add(new Task(id, description));
        saveChanges();
    }

    public static void updateTask(int id, String description) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                saveChanges();
                System.out.printf("Task \"%d\" foi editada com Sucesso!\n", id);
                return;
            }
        }
        System.out.printf("Tarefa com o ID %d não existe!\n", id);
    }

    public static void changeTaskStatus(int id, Status status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                saveChanges();
                System.out.printf("Task \"%d\" alterada para o status %s\n", id, status.toString());
                return;
            }
        }
        System.out.printf("Tarefa com o ID %d não existe!\n", id);
    }

    public static void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                saveChanges();
                System.out.printf("Task \"%d\" foi removida com Sucesso!\n", id);
                return;
            }
        }
        System.out.printf("Tarefa com o ID %d não existe!\n", id);
    }

    public static void listTasks() {
        System.out.println("-------------");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("-------------");
    }

    public static void listTasks(Status status) {
        System.out.println("-------------");
        for (Task task : tasks) {
            if(task.getStatus().equals(status)){
                System.out.println(task);
            }
        }
        System.out.println("-------------");
    }

    private static void saveChanges() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        File file = new File("tarefas.json");
        try {
            mapper.writeValue(file, tasks);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
}

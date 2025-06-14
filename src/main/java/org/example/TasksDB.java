package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TasksDB {
    private static ArrayList<Task> tasks;

    TasksDB(){}
    public static void connectDatabase() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        File file = new File("tarefas.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
                mapper.writeValue(file,mapper.createArrayNode());
                System.out.println("Arquivo tarefas.json criado!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tasks = mapper.readValue(file,new TypeReference<ArrayList<Task>>() {});
    }
    public static void addTask(String description){
        tasks.add(new Task(description));
        saveChanges();
    }
    private static void saveChanges(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        File file = new File("tarefas.json");
        try{
            mapper.writeValue(file,tasks);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Task> getTasks(){
        return tasks;
    }
}

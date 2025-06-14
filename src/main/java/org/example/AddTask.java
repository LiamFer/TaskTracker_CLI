package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "add", mixinStandardHelpOptions = true, version = "taskcli 1.0",
        description = "Adds a new task.")
public class AddTask implements Callable<Integer> {
    @Parameters(index = "0", description = "The task name.")
    private String description;

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.addTask(description);
        System.out.printf("Task \"%s\" foi criada com Sucesso!\n",description);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
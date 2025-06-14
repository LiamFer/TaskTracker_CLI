package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "update", mixinStandardHelpOptions = true, version = "taskcli 1.0",
        description = "Updates the Task.")
public class UpdateTask implements Callable<Integer> {
    @Parameters(index = "0", description = "The task id.")
    private int id;

    @Parameters(index = "1", description = "The new task name.")
    private String description;

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.updateTask(id,description);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
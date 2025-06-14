package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "delete", mixinStandardHelpOptions = true, version = "taskcli 1.0",
        description = "Deletes the Task.")
public class DeleteTask implements Callable<Integer> {
    @Parameters(index = "0", description = "The task id.")
    private int id;

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.deleteTask(id);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
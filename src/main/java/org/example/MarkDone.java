package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "mark-done", mixinStandardHelpOptions = true, version = "taskcli 1.0",
        description = "Changes the Task Status to Done.")
public class MarkDone implements Callable<Integer> {
    @Parameters(index = "0", description = "The task id.")
    private int id;

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.changeTaskStatus(id,Status.DONE);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
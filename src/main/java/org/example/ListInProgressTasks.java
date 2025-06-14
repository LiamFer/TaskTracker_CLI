package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "in-progress",
        description = "Lista apenas tarefas pendentes"
)
public class ListInProgressTasks implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.listTasks(Status.IN_PROGRESS);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}

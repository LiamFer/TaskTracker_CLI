package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "list", mixinStandardHelpOptions = true, version = "taskcli 1.0",
        description = "List all the Tasks.", subcommands = {ListDoneTasks.class,ListTodoTasks.class})
public class ListTasks implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.listTasks();
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
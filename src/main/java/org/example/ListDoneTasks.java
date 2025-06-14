package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(
        name = "done",
        description = "Lista apenas tarefas concluídas"
)
public class ListDoneTasks implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TasksDB.connectDatabase();
        TasksDB.listTasks(Status.DONE);
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
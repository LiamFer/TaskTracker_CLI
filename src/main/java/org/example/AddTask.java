package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "add", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
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

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new AddTask()).execute(args);
        System.exit(exitCode);
    }
}
package org.example;


import picocli.CommandLine;
import picocli.CommandLine.Command;



@Command(
        name = "task-cli",
        mixinStandardHelpOptions = true,
        version = "task-cli 1.0",
        description = "Aplicativo de tarefas no terminal.",
        subcommands = {AddTask.class, UpdateTask.class, DeleteTask.class}
)
public class Main implements Runnable {
    @Override
    public void run() {
        System.out.println("Use um comando, ex: add, list, remove");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}





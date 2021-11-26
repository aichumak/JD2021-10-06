package by.it.chumak.jd01_15;

import java.util.Scanner;

public class TaskC {
    private static final String EXIT_COMMAND = "end";

    public static void main(String[] args) {
        CurrentDirectoryEntity currentDirectoryEntity = setCurrentDirectoryEntity();

        runCommand(currentDirectoryEntity);
    }

    private static CurrentDirectoryEntity setCurrentDirectoryEntity() {
        PathMethods pathMethods = new GetPath();
        String path = pathMethods.getDirPath(TaskC.class);

        return new CurrentDirectoryEntity(path);
    }

    private static void runCommand(CurrentDirectoryEntity currentDirectoryEntity) {
        CommandProcessorMethods commandProcessor = new CommandProcessor();
        Scanner sc = new Scanner(System.in);
        String command;

        for (; ; ) {
            System.out.print(currentDirectoryEntity.getValue());
            command = sc.nextLine();
            if (command.equalsIgnoreCase(EXIT_COMMAND)) {
                break;
            } else {
                commandProcessor.processCommand(command, currentDirectoryEntity);
                System.out.println();
            }

        }
    }
}

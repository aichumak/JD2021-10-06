package by.it.chumak.jd01_15;

import java.util.Scanner;

public class TaskC {
    private static final String EXIT_COMMAND = "end";

    public static void main(String[] args) {
        CurrentDirectoryEntity currentDirectoryEntity = initCommandLine();
        runCommandLine(currentDirectoryEntity);
    }

    private static CurrentDirectoryEntity initCommandLine() {
        PathMethods pathMethods = new GetPath();
        String path = pathMethods.getDirPath(TaskC.class);

        return new CurrentDirectoryEntity(path);
    }

    private static void runCommandLine(CurrentDirectoryEntity currentDirectoryEntity) {
        CommandProcessorMethods commandHandler = new CommandProcessor();
        Scanner sc = new Scanner(System.in);
        String command;

        for (;;) {
            System.out.print(currentDirectoryEntity.getValue());
            command = sc.nextLine();
            if (command.equalsIgnoreCase(EXIT_COMMAND)){
                break;
            } else {
                commandHandler.processCommand(command, currentDirectoryEntity);
            }

        }
    }
}

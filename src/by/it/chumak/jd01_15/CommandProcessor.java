package by.it.chumak.jd01_15;

import java.io.File;

public class CommandProcessor implements CommandProcessorMethods {

    public CommandProcessor() {
    }

    @Override
    public void processCommand(String command, CurrentDirectoryEntity currentDirectoryEntity) {
        if (command.equalsIgnoreCase("dir")) {
            processDirCommand(currentDirectoryEntity);
        } else if (command.equalsIgnoreCase("cd..")) {
            processCdCommand(currentDirectoryEntity);
        }
    }

    private void processDirCommand(CurrentDirectoryEntity currentDirectoryEntity) {

    }

    private void processCdCommand(CurrentDirectoryEntity currentDirectoryEntity) {
        CurrentDirectoryMethods currentDirectoryService = new CurrentDirectoryService();
        File file = new File(currentDirectoryService.getCurrentDirectory(currentDirectoryEntity));

        currentDirectoryService.setCurrentDirectory(currentDirectoryEntity, file.getParent() + ">");
    }
}

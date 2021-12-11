package by.it.chumak.jd01_15;

import java.io.File;
import java.util.*;

public class CommandProcessor implements CommandProcessorMethods {

    private static final String ERROR_MESSAGE_PATH_NOT_FOUND = "Системе не удается найти указанный путь.";
    private static final String DIR_TEXT = "<DIR>";

    public CommandProcessor() {
    }

    @Override
    public void processCommand(String command, CurrentDirectoryEntity currentDirectoryEntity) {
        if (command.equalsIgnoreCase("dir")) {
            processDirCommand(currentDirectoryEntity);
        } else if (command.equalsIgnoreCase("cd ..")) {
            processCdCommand(currentDirectoryEntity);
        } else if (command.substring(0, 3).equalsIgnoreCase("cd ")) {
            processCdDirCommand(currentDirectoryEntity, command.substring(3));
        }
    }

    private void processDirCommand(CurrentDirectoryEntity currentDirectoryEntity) {
        CurrentDirectoryMethods currentDirectoryService = new CurrentDirectoryService();
        File file = new File(currentDirectoryService.getCurrentDirectory(currentDirectoryEntity));
        File[] dirList = file.listFiles();

        if (dirList != null) {
            for (File data : dirList) {
                System.out.println();
                System.out.print(getFileDescription(data));
            }
        }
    }

    private void processCdCommand(CurrentDirectoryEntity currentDirectoryEntity) {
        CurrentDirectoryMethods currentDirectoryService = new CurrentDirectoryService();
        File file = new File(currentDirectoryService.getCurrentDirectory(currentDirectoryEntity));

        currentDirectoryService.setCurrentDirectory(currentDirectoryEntity, file.getParent());
    }

    private void processCdDirCommand(CurrentDirectoryEntity currentDirectoryEntity, String dir) {
        CurrentDirectoryMethods currentDirectoryService = new CurrentDirectoryService();
        File file = new File(currentDirectoryService.getCurrentDirectory(currentDirectoryEntity));
        String[] arrayDirectoriesAndFiles = file.list();

        if (arrayDirectoriesAndFiles != null) {
            List<?> dirList = Arrays.asList(arrayDirectoriesAndFiles);
            if (dirList.contains(dir)) {
                currentDirectoryService.setCurrentDirectory(currentDirectoryEntity,
                        currentDirectoryService.getCurrentDirectory(currentDirectoryEntity) + "\\" + dir);
            } else {
                System.out.print(ERROR_MESSAGE_PATH_NOT_FOUND);
                System.out.println();
            }
        }
    }

    private String getFileDescription(File data) {
        Calendar calendar = new GregorianCalendar();

        calendar.setTime(new Date(data.lastModified()));

        return String.format(Locale.US, "%02d.%02d.%d  %02d:%02d    %s %s", calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR), calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE),
                getOtherFileAttributes(data), data.getName());
    }

    private String getOtherFileAttributes(File data) {
        if (data.isDirectory()) {
            return String.format(Locale.US, "%-14s", DIR_TEXT);
        } else {
            return String.format(Locale.US, "%14d", data.length());
        }
    }

}

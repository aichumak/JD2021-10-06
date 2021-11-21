package by.it.chumak.jd01_14;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    private static final String FILENAME_TASK_C = "resultTaskC.txt";
    private static final String PREFIX_FILE = "file:";
    private static final String PREFIX_DIR = "dir:";

    public static void main(String[] args) throws IOException {
        GetPathMethod getPathMethod = new GetPathMethod();
        String path = getPathMethod.getDirPath(TaskC.class);
        ArrayList<File> fileList = new ArrayList<>();
        ArrayList<File> folderList = new ArrayList<>();

        completeArrayLists(path, fileList, folderList);
        printResults(getPathMethod.getFilePath(TaskC.class, FILENAME_TASK_C), fileList, folderList);
    }

    private static void completeArrayLists(String path, ArrayList<File> fileList, ArrayList<File> folderList) {
        File file = new File(path);
        File[] folders = file.listFiles(File::isDirectory);
        File[] files = file.listFiles(File::isFile);

        if (files != null) {
            fileList.addAll(List.of(files));
        }

        if (folders != null) {
            folderList.addAll(List.of(folders));
        } else {
            return;
        }

        for (File folder : folders) {
            completeArrayLists(folder.getPath(), fileList, folderList);
        }
    }

    private static void printResults(String path, ArrayList<File> fileList, ArrayList<File> folderList) throws IOException {
        StringBuilder filesStringBuilder = new StringBuilder();
        StringBuilder foldersStringBuilder = new StringBuilder();
        PrintToFile printToFile = new PrintToFile();

        completeStringBuilder(PREFIX_FILE, filesStringBuilder, fileList);
        completeStringBuilder(PREFIX_DIR, foldersStringBuilder, folderList);

        System.out.println(filesStringBuilder);
        System.out.println(foldersStringBuilder);
        printToFile.printStringToFile(path, filesStringBuilder.toString() + foldersStringBuilder);

    }

    private static void completeStringBuilder(String prefix, StringBuilder stringBuilder, ArrayList<File> arrayList) {
        for (File element : arrayList) {
            stringBuilder.append(prefix);
            stringBuilder.append(element.getName());
            stringBuilder.append("\n");
        }
    }

}


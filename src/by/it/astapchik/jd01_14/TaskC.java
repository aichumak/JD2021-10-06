package by.it.astapchik.jd01_14;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

class TaskC {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        File directoryPath = new File(System.getProperty("user.dir") + "/src/by/it/astapchik/");
        get(directoryPath);
        writeInFile(arrayList);
    }

    private static void writeInFile(ArrayList<String> arrayList) {
        String resultTaskC = FileNames.getFullPath( "resultTaskC.txt", TaskC.class);
        try (PrintWriter printWriter = new PrintWriter(resultTaskC)){
            for (String s : TaskC.arrayList) {
                printWriter.println(s);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void get(File directoryPath) {
        for (File file : directoryPath.listFiles()) {
            String name = file.getName();
            if (file.isDirectory()){
                arrayList.add("dir:" + name);
                get(file);
            } else if (file.isFile()) {
                arrayList.add("file:" + name);
            }
        }
    }
}

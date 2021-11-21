package by.it.drankevich.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it"
                + File.separator + "drankevich" + File.separator;

        File dir = new File(path);

        recurs(dir);

        printToFile(dir);
    }


    private static void recurs(File dir) {


        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.printf("dir:%s%n", file.getName());
                recurs(file);
            } else {
                System.out.printf("file:%s%n", file.getName());
            }


        }
    }

    private static void printToFile(File dir) {
        String filename = Filenames.getFullPath(TaskC.class, "resultTaskC.txt");
        try (PrintWriter printWriter = new PrintWriter(filename)) {

            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    printWriter.printf("dir:%s%n", file.getName());
                    printToFile(file);
                } else {
                    printWriter.printf("file:%s%n", file.getName());

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}




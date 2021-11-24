package by.it.drankevich.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class TaskC {
    public static StringJoiner sj = new StringJoiner("\n", "", "");

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by"
                + File.separator + "it" + File.separator + "drankevich" + File.separator;

        File dir = new File(path);
        recurs(dir);
        printToFile(sj.toString());

    }


    private static void recurs(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.printf("dir:%s%n", file.getName());
                sj.add("dir:" + file.getName());
                recurs(file);
            } else {
                System.out.printf("file:%s%n", file.getName());
                sj.add("file:" + file.getName());
            }


        }
    }

    private static void printToFile(String file) {
        String filename = Filenames.getFullPath(TaskC.class, "resultTaskC.txt");
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            printWriter.print(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}




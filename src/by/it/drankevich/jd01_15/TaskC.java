package by.it.drankevich.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by"
                + File.separator + "it" + File.separator + "drankevich" + File.separator + "jd01_15" + File.separator;
        File file = new File(path);

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String command = scanner.nextLine();
            if (command.equals("end")) break;

            else {

                if (command.equals("dir")) {
                    System.out.println("Содержимое папки:" + file.getAbsolutePath());
                    for (File s : Objects.requireNonNull(file.listFiles())) {
                        if (s.isDirectory()) {
                            System.out.printf("%1$td.%1$tm.%1$ty  %1$tH:%1$tM  <DIR>   %2$s%n",
                                    new Date(s.lastModified()), s.getName());
                        } else {

                            System.out.printf("%1$td.%1$tm.%1$ty  %1$tH:%1$tM        %2$s%n",
                                    new Date(s.lastModified()), s.getName());

                        }
                    }
                }

                if (command.startsWith("cd\s")) {
                    String directory = command.replace("cd\s", "");
                    file = new File(file, directory);
                    System.out.println(file.getAbsolutePath());

                }

                if (command.equals("cd..")) {
                    file = new File(file.getParent());
                    System.out.println(file.getAbsolutePath());

                }
            }


        }
    }
}



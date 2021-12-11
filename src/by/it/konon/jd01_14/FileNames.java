package by.it.konon.jd01_14;

import java.io.File;

public class FileNames {
    private FileNames(){

    }
     public static String getFullPath(String fileName, Class<?> currentClass) {
        String srcProject = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String name = currentClass.getName();
        String currentClassSimpleName = currentClass.getSimpleName();
        String relationPath = name
                .replace(currentClassSimpleName, "")
                .replace(".", File.separator);

        return srcProject + relationPath + fileName;
    }
}


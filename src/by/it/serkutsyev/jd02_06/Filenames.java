package by.it.serkutsyev.jd02_06;

import java.io.File;

public class Filenames {
    public Filenames() {
    }
    public static String findFilePath(String fileName, Class<?> taskAClass) {
        String scrPath = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classFullName = taskAClass.getName();
        String classSimpleName = taskAClass.getSimpleName();
        String classPath = classFullName.replace(classSimpleName, "").replace(".", File.separator);
        String filePath = scrPath+classPath+ fileName;
        return filePath;
    }

}

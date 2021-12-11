package by.it.astapchik.jd01_15;

import java.io.File;

public class FileNames {
    private FileNames(){

    }

    public static String getFullPath(String fileName, Class<?> structureClass) {
        String srcProject = System.getProperty("user.dir") + File.separator + "src" +File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name.replace(simpleName, "").replace(".", File.separator);
        return srcProject + relationPath + fileName;
    }
}

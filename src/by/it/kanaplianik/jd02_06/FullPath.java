package by.it.kanaplianik.jd02_06;

import java.io.File;

public class FullPath {
    public static String getFullPath(String filenameWriteTo, Class<?> structureClass) {
        String srcProject = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name
                .replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPath + filenameWriteTo;
    }
}

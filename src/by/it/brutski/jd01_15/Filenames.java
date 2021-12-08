package by.it.brutski.jd01_15;

import java.io.File;

public class Filenames {
    private Filenames(){

    }

    public static String getPath(String filename, Class<?> structureClass) {
        String srcProject = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name.replace(simpleName, "").replace(".", File.separator);

        return srcProject + relationPath + filename;
    }
}

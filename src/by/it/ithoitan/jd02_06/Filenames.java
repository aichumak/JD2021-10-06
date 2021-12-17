package by.it.ithoitan.jd02_06;

import java.io.File;

public class Filenames {
    public Filenames() {
    }

    public static String getPath(String filename, Class<?> structureClass) {
        String srcProject = System.getProperty("user.dir")
                + File.separator + "src" + File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPatn = name.replace(simpleName, "")
                .replace(".", File.separator);
        return srcProject + relationPatn + filename;
    }
}

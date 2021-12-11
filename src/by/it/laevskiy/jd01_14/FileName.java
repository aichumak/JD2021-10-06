package by.it.laevskiy.jd01_14;

import java.io.File;

public class FileName {
    public FileName() {
    }

     static String getFullPath(String fileName, Class<?> structureClass) {
        String rootProperty = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator;
        String name = structureClass.getName();
        String simpleName = structureClass.getSimpleName();
        String relationPath = name.replace(simpleName, "")
                .replace(".", File.separator);
        return (rootProperty + relationPath + fileName);
    }
}

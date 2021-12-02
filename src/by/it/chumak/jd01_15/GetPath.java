package by.it.chumak.jd01_15;

import java.io.File;

public class GetPath implements PathMethods {

    private final String SRC_PROJECT = System.getProperty("user.dir") + File.separator + "src" + File.separator;

    @Override
    public String getFilePath(Class<?> structureClass, String fileName) {
        String relationPath = structureClass.getName().replace(structureClass.getSimpleName(), "").replace(".", File.separator);

        return SRC_PROJECT + relationPath + fileName;
    }

    @Override
    public String getDirPath(Class<?> structureClass) {
        String path = structureClass.getName().replace(structureClass.getSimpleName(), "").replace(".", File.separator);
        File directory = new File(SRC_PROJECT + path);

        return directory.getPath();
    }
}

package by.it.chumak.jd01_14;

import java.io.File;

public class GetPathMethod implements PathMethods {

    private final String SRC_PROJECT = System.getProperty("user.dir") + File.separator + "src" + File.separator;

    public GetPathMethod() {
    }

    @Override
    public String getFilePath() {
        return null;
    }

    @Override
    public String getFilePath(Class<?> structureClass, String fileName) {
        String relationPath = structureClass.getName().replace(structureClass.getSimpleName(), "").replace(".", File.separator);

        return SRC_PROJECT + relationPath + fileName;
    }

    @Override
    public String getDirPath(Class<?> structureClass) {
        String path = structureClass.getName().replace(structureClass.getSimpleName(), "").replace(".", File.separator);
        File directory = new File(SRC_PROJECT + path);

        return directory.getPath().replace(directory.getName(), "");
    }
}

package by.it.chumak.jd01_14;

import java.io.File;

public class GetPathMethod implements PathMethods {

    private final String SRC_PROJECT = System.getProperty("user.dir") + File.separator + "src" + File.separator;

    public GetPathMethod() {
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public String getPath(Class<?> structureClass, String fileName) {
        String relationPath = structureClass.getName().replace(structureClass.getSimpleName(), "").replace(".", File.separator);
        return SRC_PROJECT + relationPath + fileName;
    }
}

package by.it.chumak.calc.model;

import java.io.File;

public class GetPathMethod implements PathMethods {

    private final String SRC_PROJECT = System.getProperty("user.dir") + File.separator + "JD2021-10-06" + File.separator + "src" + File.separator;

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

}

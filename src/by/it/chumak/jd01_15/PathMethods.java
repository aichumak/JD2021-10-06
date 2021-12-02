package by.it.chumak.jd01_15;

public interface PathMethods {

    default String getFilePath(Class<?> structureClass, String fileName) {
        return null;
    }

    default String getDirPath(Class<?> structureClass) {
        return null;
    }

}

package by.it.chumak.jd01_14;

public interface PathMethods {

    String getFilePath();

    default String getFilePath(Class<?> structureClass, String fileName) {
        return null;
    }

    default String getDirPath(Class<?> structureClass) {
        return null;
    }

}

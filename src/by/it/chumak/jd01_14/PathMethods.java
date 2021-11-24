package by.it.chumak.jd01_14;

public interface PathMethods {

    @SuppressWarnings("unused")
    String getFilePath();

    default String getFilePath(Class<?> structureClass, String fileName) {
        return null;
    }

    default String getDirPath(Class<?> structureClass) {
        return null;
    }

}

package by.it.chumak.jd02_06.model;

public interface PathMethods {

    @SuppressWarnings("unused")
    String getFilePath();

    default String getFilePath(Class<?> structureClass, String fileName) {
        return null;
    }

}

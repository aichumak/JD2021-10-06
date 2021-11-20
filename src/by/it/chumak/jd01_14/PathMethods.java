package by.it.chumak.jd01_14;

public interface PathMethods {

    String getPath();

    default String getPath(Class<?> structureClass, String fileName) {
        return null;
    }

}

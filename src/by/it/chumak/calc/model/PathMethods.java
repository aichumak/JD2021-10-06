package by.it.chumak.calc.model;

public interface PathMethods {

    @SuppressWarnings("unused")
    String getFilePath();

    default String getFilePath(Class<?> structureClass, String fileName) {
        return null;
    }

}

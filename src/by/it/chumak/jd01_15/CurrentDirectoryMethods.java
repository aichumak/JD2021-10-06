package by.it.chumak.jd01_15;

public interface CurrentDirectoryMethods {

    default void setCurrentDirectory(CurrentDirectoryEntity currentDirectoryEntity, String currentDirectory) {
    }

    default String getCurrentDirectory(CurrentDirectoryEntity currentDirectoryEntity) {
        return null;
    }
}

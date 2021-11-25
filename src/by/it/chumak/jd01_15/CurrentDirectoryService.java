package by.it.chumak.jd01_15;

public class CurrentDirectoryService implements CurrentDirectoryMethods{

    @Override
    public void setCurrentDirectory(CurrentDirectoryEntity currentDirectoryEntity, String currentDirectory) {
        currentDirectoryEntity.setValue(currentDirectory);
    }

    @Override
    public String getCurrentDirectory(CurrentDirectoryEntity currentDirectoryEntity) {
        return currentDirectoryEntity.getValue();
    }

}

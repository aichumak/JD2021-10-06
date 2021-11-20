package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.List;

public interface WriteFileMethods {

    void writeFile() throws IOException;

    default void writeIntegerToFile(String path, List<Integer> integerList) throws IOException {
    }

    default void writeIntegerToFile(String path, Integer value) throws IOException {
    }

}

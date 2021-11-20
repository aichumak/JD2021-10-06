package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.ArrayList;

public interface ReadFileMethods {

    void readFile() throws IOException;

    default void readFile(String path, ArrayList<Integer> integerArrayList) throws IOException {
    }

    default void readFile(String path, StringBuilder stringBuilder) throws IOException {
    }

}

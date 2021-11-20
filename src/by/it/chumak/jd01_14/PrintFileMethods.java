package by.it.chumak.jd01_14;

import java.io.IOException;
import java.util.ArrayList;

public interface PrintFileMethods {

    void printToFile();

    default void printListToFile(String path, double avg, ArrayList<Integer> integerArrayList) throws IOException {
    }

    default void printStringToFile(String path, String textLine) throws IOException {
    }
}

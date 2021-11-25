package by.it.chumak.jd01_15;

import java.util.ArrayList;

public interface PrintToFileMethods {

    default void printListToFile(String path, double avg, ArrayList<Integer> integerArrayList) throws ExceptionsInfo {
    }

    default void printMatrixToFile(String path, int[][] integerArray) throws ExceptionsInfo {
    }

    default void printStringToFile(String path, String textLine) throws ExceptionsInfo {
    }
}

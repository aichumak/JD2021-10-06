package by.it.chumak.jd01_15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

public class PrintToFile implements PrintToFileMethods {
    public static final String FORMAT_ONE_INT = "%3d ";

    @Override
    public void printListToFile(String path, double avg, ArrayList<Integer> integerArrayList) throws ExceptionsInfo {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (Integer integer : integerArrayList) {
                printWriter.printf(FORMAT_ONE_INT, integer);
            }
            printWriter.printf(String.format(Locale.US, "avg=%f%n", avg));
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    @Override
    public void printStringToFile(String path, String textLine) throws ExceptionsInfo {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.printf("%s%n", textLine);
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

    @Override
    public void printMatrixToFile(String path, int[][] integerArray) throws ExceptionsInfo {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            for (int[] row : integerArray) {
                for (int element : row) {
                    printWriter.printf(FORMAT_ONE_INT, element);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            throw new ExceptionsInfo();
        }
    }

}

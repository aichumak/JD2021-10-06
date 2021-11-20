package by.it.chumak.jd01_14;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintToFile implements PrintFileMethods {
    public static final String FORMAT_ONE_INT = "%d ";
    public static final String FORMAT_AVG = "%navg=%f%n";

    @Override
    public void printToFile() {
    }

    @Override
    public void printListToFile(String path, double avg, ArrayList<Integer> integerArrayList) throws IOException {
        PrintWriter printWriter = new PrintWriter(path);

        for (Integer integer : integerArrayList) {
            printWriter.printf(FORMAT_ONE_INT, integer);
        }
        printWriter.printf(FORMAT_AVG, avg);
    }

    @Override
    public void printStringToFile(String path, String textLine) throws IOException {
        PrintWriter printWriter = new PrintWriter(path);
        printWriter.print(textLine);
        printWriter.close();
    }
}

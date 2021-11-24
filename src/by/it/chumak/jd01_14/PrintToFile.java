package by.it.chumak.jd01_14;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;

public class PrintToFile implements PrintToFileMethods {
    public static final String FORMAT_ONE_INT = "%d ";

    @Override
    public void printToFile() {
    }

    @Override
    public void printListToFile(String path, double avg, ArrayList<Integer> integerArrayList) throws IOException {
        PrintWriter printWriter = new PrintWriter(path);

        for (Integer integer : integerArrayList) {
            printWriter.printf(FORMAT_ONE_INT, integer);
        }
        printWriter.printf(String.format(Locale.US, "avg=%f%n", avg));
        printWriter.close();
    }

    @Override
    public void printStringToFile(String path, String textLine) throws IOException {
        PrintWriter printWriter = new PrintWriter(path);
        printWriter.printf("%s%n", textLine);
        printWriter.close();
    }
}

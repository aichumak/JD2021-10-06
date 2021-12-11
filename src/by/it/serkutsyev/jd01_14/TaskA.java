package by.it.serkutsyev.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    public static final String FILE_INTEGER = "dataTaskA.bin";
    public static final int MAX_INT = 1000;
    public static final String FORMAT_ONE_INT = "%d ";
    public static final String FORMAT_AVG = "%navg=%f%n";
    public static final String RESULT_TXT = "resultTaskA.txt";

    public static void main(String[] args) {
        String filePath = Filenames.findFilePath(FILE_INTEGER, TaskA.class);
        generateIntFile(filePath);
        ArrayList<Integer> integers = readIntegers(filePath);
        printToConsole(integers);
        String txtPath = Filenames.findFilePath(RESULT_TXT, TaskA.class);
        printToFile(integers, txtPath);
    }

    private static ArrayList<Integer> readIntegers(String filePath) {

        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {
            while (dataInputStream.available() > 0) {

                integers.add(dataInputStream.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void generateIntFile(String filePath) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))
        ) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {

                dataOutputStream.writeInt(random.nextInt(MAX_INT));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            System.out.printf(FORMAT_ONE_INT, integers.get(i));
            sum = sum + integers.get(i);
        }
        System.out.printf(FORMAT_AVG, sum / integers.size());
    }

    private static void printToFile(ArrayList<Integer> integers, String txtPath) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            double sum2 = 0;
            for (int i = 0; i < integers.size(); i++) {
                printWriter.printf(FORMAT_ONE_INT, integers.get(i));
                sum2 = sum2 + integers.get(i);
            }
            printWriter.printf(Locale.ENGLISH,FORMAT_AVG, sum2 / integers.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

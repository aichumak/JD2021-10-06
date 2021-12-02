package by.it.vrublevskii.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class TaskA {

    public static final String FILE_INTEGER = "dataTaskA.bin";
    public static final int MAX_INT = 1000;
    public static final String FORMAT_ONE_INT = "%d ";
    public static final String FORMAT_AVG = "%navg=%.2f%n";
    public static final String RESULT_TXT = "resultTaskA.txt";


    public static void main(String[] args) {
        String fileName = FileNames.getFullPath(FILE_INTEGER, TaskA.class);
        createIntFiles(fileName);
        ArrayList<Integer> integers = readIntegers(fileName);
        printToConsole(integers);
        String txtOut = FileNames.getFullPath(RESULT_TXT, TaskA.class);
        printToFile(integers, txtOut);
    }

    private static void createIntFiles(String fileName) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(fileName)
                        )
                )
        ) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(MAX_INT));
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName);
        }
    }

    private static ArrayList<Integer> readIntegers(String fileName) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(fileName)
                        )
                )
        ) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName);
        }
        return integers;
    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer : integers) {
            System.out.printf(Locale.US, FORMAT_ONE_INT, integer);
            sum += integer;
        }
        System.out.printf(Locale.ENGLISH, FORMAT_AVG, sum / integers.size());
    }

    private static void printToFile(ArrayList<Integer> integers, String txtOut) {
        try (PrintWriter printWriter = new PrintWriter(txtOut)) {
            double sum2 = 0;
            for (Integer integer : integers) {
                printWriter.printf(Locale.ENGLISH, FORMAT_ONE_INT, integer);
                sum2 += integer;
            }
            printWriter.printf(Locale.ENGLISH, FORMAT_AVG, sum2 / integers.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

package by.it.konon.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class TaskA {

    public static final String FILE_INTEGER = "dataTaskA.bin";
    public static final int MAX_INT = 1000;
    public static final String FORMAT_ONE_INT = "%d ";
    public static final String FORMAT_AVG = "%navg=%f%n";
    public static final String RESULT_TXT = "resultTaskA.txt";

    public static void main(String[] args) {

        String fileName = FileNames.getFullPath(FILE_INTEGER, TaskA.class);
        generateIntFile(fileName);
        ArrayList<Integer> integers = readInteger(fileName);
        printToConsole(integers);
        String txtFileName = FileNames.getFullPath(RESULT_TXT, TaskA.class);
        printToFile(integers, txtFileName);
    }

    private static void printToFile(ArrayList<Integer> integers, String txtFileName) {
        try (PrintWriter printWriter = new PrintWriter(txtFileName)) {
            double sum2 = 0;
            for (Integer integer : integers) {
                printWriter.printf(FORMAT_ONE_INT, integer);
                sum2 += integer;
            }
            printWriter.printf(FORMAT_AVG, sum2 / integers.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer : integers) {
            System.out.print(integer + " ");
            sum += integer;

        }
        System.out.printf(FORMAT_AVG,sum / integers.size());
        System.out.print("avg="+sum / integers.size());
    }

    private static ArrayList<Integer> readInteger(String fileName) {
        ArrayList<Integer> integers = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)
                )
        )
        ) {
            while (dataInputStream.available() > 0) {
                integers.add(dataInputStream.readInt());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return integers;
    }

    private static void generateIntFile(String fileName) {
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
            throw new RuntimeException(e);
        }
    }
}


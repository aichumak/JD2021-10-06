package by.it.astapchik.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class TaskA {

    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";
    public static final int BOUND = 1000;

    public static void main(String[] args) {
        String filename = FileNames.getFullPath( DATA_TASK_A_BIN, TaskA.class);
        generateIntFile(filename);
        ArrayList<Integer> integers = readInteger(filename);
        printToConsole(integers);
        String resultTaskA = FileNames.getFullPath(RESULT_TASK_A_TXT, TaskA.class);
        printInFile(integers, resultTaskA);

    }

    private static void generateIntFile(String filename) {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(
                        new BufferedOutputStream
                                  (new FileOutputStream(filename))
                )
        ) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt(random.nextInt(BOUND));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Integer> readInteger(String filename) {
        ArrayList<Integer> integers = new ArrayList<>();
        try(
                DataInputStream dataInputStream = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(filename)
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

    private static void printToConsole(ArrayList<Integer> integers) {
        double sum = 0;
        for (Integer integer : integers) {
            System.out.print(integer + " ");
            sum += integer;
        }
        System.out.println("avg=" + sum / integers.size());
    }

    private static void printInFile(ArrayList<Integer> integers, String resultTaskA) {
        double sum2 = 0;
        try (PrintWriter printWriter = new PrintWriter(resultTaskA)) {
            for (Integer integer : integers) {
                printWriter.print(integer + " ");
                sum2 += integer;
            }
            printWriter.print("avg="+ sum2 / integers.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package by.it.drankevich.jd01_15;

import by.it.drankevich.jd01_14.Filenames;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {

        int[][] array = generateArray(6, 4, 15, -15);
        String filename = Filenames.getFullPath(TaskA.class, "matrix.txt");
        writeInFile(filename, array);
        printToConsole(filename);

    }

    private static int[][] generateArray(int rowCount, int colCount, int max, int min) {
        int[][] array = new int[rowCount][colCount];
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {

                row[i] = random.nextInt(max - min + 1) + min;
            }

        }
        return array;
    }


    private static void writeInFile(String filename, int[][] array) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {

            for (int[] ints : array) {
                for (int anInt : ints) {
                    printWriter.printf("%3d ", anInt);

                }
                printWriter.println();

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }

    }


    private static void printToConsole(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

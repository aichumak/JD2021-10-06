package by.it.astapchik.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class TaskA {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(6, 4, -15, 15);
        String filename = "matrix.txt";
        writeInFile(matrix, filename);
        List<String> strings = readFile(filename);
        printToConsole(strings);
    }


    private static int[][] generateMatrix(int rowCount, int colCount, int min, int max) {
        int[][] matrix = new int[rowCount][colCount];
        Random random = new Random();
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
        return matrix;
    }

    private static void writeInFile(int[][] matrix, String filename) {
        String createFilename = FileNames.getFullPath(filename, TaskA.class);
        try (PrintWriter printWriter = new PrintWriter(createFilename)){
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    printWriter.printf("%3d ", row[i]);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readFile(String filename) {
        List<String> arrayList = new ArrayList<>();
        String createFilename = FileNames.getFullPath(filename, TaskA.class);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFilename))){
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                arrayList.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

}

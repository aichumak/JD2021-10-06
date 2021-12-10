package by.it.serkutsyev.jd01_15;

import by.it.serkutsyev.jd01_14.Filenames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int array[][] = generateArray(6, 4, 15);
        String fileName = "matrix.txt";
        printArrayToFile(array, fileName);
        List<String> strings = readFromFile(fileName);
        printToConsole(strings);
    }

    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }

    }

    private static List<String> readFromFile(String fileName) {
        String filePath = Filenames.findFilePath(fileName, TaskA.class);
        List<String> strings = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (!Objects.isNull(line) && !line.isEmpty()) {
                    strings.add(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return strings;
    }

    private static void printArrayToFile(int[][] array, String fileName) {
        String filePath = Filenames.findFilePath(fileName, TaskA.class);
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (int[] rows : array) {
                for (int element : rows) {
                    printWriter.printf("%4d", element);
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[][] generateArray(int rows, int coloumns, int border) {
        int[][] array = new int[rows][coloumns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < coloumns; j++) {
                array[i][j] = random.nextInt((border * 2) + 1) - border;
            }
        }
        return array;
    }
}

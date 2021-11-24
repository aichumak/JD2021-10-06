package by.it._classwork_.jd01_15;

import by.it._classwork_.jd01_14.Filenames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        int[][] array = generateArray(6, 4, -15, 15);
        String filename = Filenames.getFullPath("matrix.txt", TaskA.class);
        saveToFile(filename, array);
        List<String> strings = readFromFile(filename);
        printToConsole(strings);

    }

    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> readFromFile(String filename) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
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

    private static void saveToFile(String filename, int[][] array) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] generateArray(int rowCount, int colCount, int min, int max) {
        int[][] array = new int[rowCount][colCount];
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
        return array;
    }
}

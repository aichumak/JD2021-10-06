package by.it.konon.jd01_15;

import by.it.konon.jd01_14.FileNames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = generateArray(6, 4, 15, -15);
        String fileName = FileNames.getFullPath("matrix.txt", TaskA.class);
        saveToFile(fileName, array);
        List<String> strings =  readToFile(fileName);
        printToConsole(strings);


    }

    private static void printToConsole(List<String> strings) {
        for (String string : strings) {
            System.out.println(string);

        }
    }

    private static List<String> readToFile(String fileName) {
        List<String> strings = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
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

    private static void saveToFile(String fileName, int[][] array) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
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

    private static int[][] generateArray(int rowCount, int colCount, int max, int min) {
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

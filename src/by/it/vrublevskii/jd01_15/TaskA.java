package by.it.vrublevskii.jd01_15;

import by.it.vrublevskii.jd01_14.FileNames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        TaskA taskA = new TaskA();
        taskA.fillMatrixWithRandomNumbers(matrix, -15, 15);
        String fullPath = FileNames.getFullPath("matrix.txt", TaskA.class);
        printMatrixToFile(matrix, fullPath);
        List<String> strings = getMatrixDataFromFile(fullPath);
        printMatrixDataToConsole(strings);
    }

    private static void printMatrixDataToConsole(List<String> strings) {
        int rowCount = strings.size();
        int[][] result = new int[rowCount][0];
        for (int i = 0; i < result.length; i++) {
            String[] parts = strings.get(i).trim().split("\\s+");
            result[i] = new int[parts.length];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Integer.parseInt(parts[j]);
                System.out.printf("% -3d ", result[i][j]);
            }
            System.out.println();
        }
    }

    private static List<String> getMatrixDataFromFile(String fullPath) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fullPath))) {
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

    private static void printMatrixToFile(int[][] matrix, String fullPath) {
        try (PrintWriter printWriter = new PrintWriter(fullPath)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("% -3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void fillMatrixWithRandomNumbers(int[][] matrix, int minValue, int maxValue) {
        Random random = new Random();
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = minValue + random.nextInt(maxValue - minValue + 1);
            }
        }
    }
}

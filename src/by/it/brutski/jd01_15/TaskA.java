package by.it.brutski.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = generateArray(6, 4, -15, 15);
        String filename = Filenames.getPath("matrix.txt", TaskA.class);
        saveFile(filename, array);
        List<String> strings = readFile(filename);
        printConsole(strings);

    }

    private static void printConsole(List<String> strings) {
        for (String string : strings) System.out.println(string);
    }

    private static List<String> readFile(String filename) {
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
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
        return strings;
    }

    private static void saveFile(String filename, int[][] array) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] string : array) {
                for (int element : string) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        }
    }

    private static int[][] generateArray(int string_Count, int column_Count, int min, int max) {
        int[][] array = new int[string_Count][column_Count];
        Random random = new Random();
        for (int[] string : array) {
            for (int i = 0; i < string.length; i++) {
                string[i] = min + random.nextInt(max - min + 1);
            }
        }
        return array;
    }
}

package by.it.laevskiy.jd01_15;


import java.io.*;
import java.util.Random;

public class TaskA {
    public static final String PRINT_FORMAT = "%3d ";
    public static final String LINE_SEPARATOR = "line.separator";

    public static void main(String[] args) throws IOException {
        int[][] array = generateArray(6, 4, -15, 15);
        String fileMatrixName = FileName.getFullPath("matrix.txt", TaskA.class);
        printToFile(array, fileMatrixName);
        StringBuilder arrayToConsole = getStringBuilder(fileMatrixName);
        System.out.println(arrayToConsole);
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] generateArray(int rowCount, int colCount, int min, int max) {
        int[][] array = new int[rowCount][colCount];
        final Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
        return array;
    }

    private static void printToFile(int[][] array, String fileMatrixName) {
        try (PrintWriter printWriter = new PrintWriter(fileMatrixName)){
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf(PRINT_FORMAT, element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static StringBuilder getStringBuilder(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder text = new StringBuilder();
        String ls = System.getProperty(LINE_SEPARATOR);
        while (null != (line = reader.readLine())) {
            text.append(line);
            text.append(ls);
        }
        text.deleteCharAt(text.length() - 1);
        return text;
    }
}


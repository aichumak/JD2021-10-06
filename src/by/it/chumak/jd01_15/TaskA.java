package by.it.chumak.jd01_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {
    private static final String FILENAME = "matrix.txt";
    private static final String PATH = new GetPath().getFilePath(TaskA.class, FILENAME);
    private static final int LENGTH1 = 6;
    private static final int LENGTH2 = 4;
    private static final int MIN = -15;
    private static final int MAX = 15;

    public static void main(String[] args) throws ExceptionsInfo {
        int[][] array = getArray();

        saveToFile(array);
        printFileToConsole();
    }

    private static int[][] getArray() {
        Random random = new Random();
        int[][] array = new int[LENGTH1][LENGTH2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = MIN + random.nextInt(MAX - MIN + 1);
            }
        }
        return array;
    }

    private static void saveToFile(int[][] array) throws ExceptionsInfo {
        PrintToFileMethods printToFileMethods = new PrintToFile();
        printToFileMethods.printMatrixToFile(PATH, array);
    }

    private static void printFileToConsole() throws ExceptionsInfo {
        List<String> listArray = new ArrayList<>();
        ReadFileMethods readFileMethods = new ReadFile();

        readFileMethods.readFile(PATH, listArray);
        System.out.println(listArray);
    }

}

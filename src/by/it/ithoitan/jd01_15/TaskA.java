package by.it.ithoitan.jd01_15;

import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = generateArray(6,4,-15,15);
    }

    private static int[][] generateArray(int rowCount, int colCount, int min, int max) {
        int[][] array = new int[rowCount][colCount];
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max+min+1);
            }
        }
        return array;
    }
}

package by.it.konon.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        array = step1(n);
    }

    private static int[][] step1(int n) {
        boolean min = false;
        boolean max = false;


        int[][] array = new int[n][n];
        while (!min || !max) {
            min = false;
            max = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 2) - n - 1);
                    if (array[i][j] == n) {
                        max = true;
                    }
                    if (array[i][j] == (-1) * n) {
                        min = true;
                    }
                }
            }

        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}
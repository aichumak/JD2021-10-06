package by.it.konon.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[][]= new int [n][n];
        array = step1(n);
    }

    private static int[][] step1(int n) {
        Random random = new Random();
        int[][] array = new int[n][n];
        boolean positive = false;
        boolean negative = false;

        while (!positive || !negative) {
            positive = false;
            negative = false;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) Math.random() *n - (n/2);

                    if (array[i][j] == n) {
                        positive = true;
                    }
                    if (array[i][j] == -n) {
                        negative = true;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }


}

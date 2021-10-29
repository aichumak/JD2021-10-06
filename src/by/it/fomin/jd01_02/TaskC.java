package by.it.fomin.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы. Число n:");
        Scanner userInput = new Scanner(System.in);
        int number = userInput.nextInt();
        step1(number);
        int[][] arrSum = step1(number);
        step2(arrSum);
    }

    private static int step2(int[][] arr) {
        // int positiveSum = 0;
        int positiveSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                positiveSum = 0;
                if (arr[i][j] > 0) {
                    do {
                        positiveSum += arr[i][j + 1];
                    } while (arr[i][j + 1] > 0);
                    System.out.println(positiveSum);
                }
                System.out.println(positiveSum);
            }
        }
        return positiveSum;


    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                do {
                    arr[i][j] = random.nextInt(2 * n + 1) - n;
                } while (arr[i][j] == -n & arr[i][j] == n);
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println();

        }
        return arr;
    }
}



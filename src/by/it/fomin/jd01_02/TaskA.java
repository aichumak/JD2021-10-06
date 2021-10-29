package by.it.fomin.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Введите числа массива");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        System.out.println("\n");
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Минимальное:" + min + " Максимальное:" + max);

    }

    private static void step2(int[] array) {
        double average = 0.00D;
        for (int j : array) {
            average = average + j;
        }
        average = average / array.length;
        for (int i : array) {
            if (i < average) {
                System.out.print(i + " ");;
            }
        }
    }

    private static void step3(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

}


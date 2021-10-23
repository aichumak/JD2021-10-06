package by.it.vrublevskii.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        step1(arr);
        step2(arr);
        step3(arr);
    }

    static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        System.out.printf("%d %d\n", min, max);
    }

    static void step2(int[] arr) {
        double b = 0;
        for (int element : arr) {
            b += (double) element / arr.length;
        }

        for (int element : arr) {
            if (element < b) {
                System.out.printf("%d ", element);
            }
        }
    }

    static void step3(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (min == arr[i]) {
                System.out.printf("%d ", i);
            }
        }
    }
}


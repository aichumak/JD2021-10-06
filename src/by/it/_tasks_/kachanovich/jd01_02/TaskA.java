package by.it._tasks_.kachanovich.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
            if (max < j) {
                max = j;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double aver = 0;
        for (int j : arr) {
            aver += j;
        }
        aver /= arr.length;
        for (int i : arr ) {
            if (i<aver){
                System.out.print(i+ " ");
            }
        }
    }
    private static void step3(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
        }
        for (int i = arr.length-1; i > -1 ; i--) {
            if (min == arr[i])
                System.out.print(i + " ");
        }
    }
}

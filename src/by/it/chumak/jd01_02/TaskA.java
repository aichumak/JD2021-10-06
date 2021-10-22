package by.it.chumak.jd01_02;


import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int element : array) {
            if (element < min) {
                min = element;
            }

            if (element > max) {
                max = element;
            }
        }

        System.out.println(min + " " + max);

    }

    private static void step2(int[] array) {
        int summ = 0;
        double avg;

        for (int element : array) {
            summ = summ + element;
        }

        avg = (double)summ / array.length;

        for (int element : array) {
            if (element < avg) {
                System.out.print(element + " ");
            }
        }

        System.out.println();

    }

    private static void step3(int[] array) {
        int min = array[0];

        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (min == array[i]) {
                System.out.print(i + " ");
                }
        }

        System.out.println();
    }
}

package by.it.konon.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();

        }
        step1(array);
        step2(array);
        step3(array);

    }

    private static void step3(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if(min == array[i]){
                System.out.print(i + " ");
            }

        }

    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        for (int element : array) {
            double avg = (double) sum / array.length;
            if (element < avg) {
                System.out.print(element + " ");
            }


        }
        System.out.println();

    }

    static void step1(int[] array) {
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
        System.out.print(min + " " + max + "\n");
    }

}

package by.it.astapchik.jd01_02;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int[] array = new int[10];
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int el : array){
            if (el < min) min = el;
            if (el > max) max = el;
        }
        System.out.println(min +" "+ max);
    }

    private static void step2(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        double avg = sum / (double)array.length;

        for (int el : array) {
            if (el < avg) System.out.print(el+" ");
        }
        System.out.println();
    }

    private static void step3(int[] array) {
        int min = array[0];
        for (int el : array){
            if (el < min) min = el;
        }
        for (int i = array.length-1; i >= 0 ; i--) {
            if (array[i]==min) {
                System.out.print(i + " ");
            }
        }
    }
}


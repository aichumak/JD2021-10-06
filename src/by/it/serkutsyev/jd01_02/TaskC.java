package by.it.serkutsyev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        step1(n);
        step2();
        step3();
    }


    private static int[][] step1(int n) {

        int[][] arr1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
            arr1[i][j] = ((int)(Math.random() * ((2*n)+1) - n));
            System.out.println(arr1[i][j]);}
        }
        return arr1;
    }

    private static void step2() {
    }

    private static void step3() {
    }

}

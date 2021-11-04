package by.it.astapchik.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] array = new int[row][column];
        for(int i=0; i < row; i++) {
            for(int j=0; j < column; j++) {
                array[i][j] = (int) (Math.random() * n);
            }
        }
        step1(array);
    }
    private static void step1(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

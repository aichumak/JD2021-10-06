package by.it.kanaplianik.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int n = myScan.nextInt();
        step1(n);

    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] matrixN;
        matrixN = new int[n][n];

        //int randomNumber=();
        for (int i = 0; i < matrixN.length; i++) {
            for (int j = 0; j < matrixN[0].length; j++) {
                matrixN[i][j] = random.nextInt(n*2)-n;
            }
        }

        for (int[] row : matrixN) {
            for (int el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }

        return matrixN;
    }
}

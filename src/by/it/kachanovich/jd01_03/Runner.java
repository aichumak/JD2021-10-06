package by.it.kachanovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] arrayDouble = {1.0, 9.0, 8.0, 5.0, 4.0, -1.0, 2.0, 6.0, 3.0, 7.0, -2.0};
        double[][] matrix = {{1,2,3},{4,5,6}};
        double[] vector = {1,2,3};
//        double[] newVector = Helper.multiply(matrix,vector);
//        for (int i = 0; i < newVector.length; i++) {
//            System.out.print(newVector[i] + " ");
//        }
        InOut.printArray(arrayDouble, "v", 5);
//        Helper.sort(arrayDouble);
    }
}

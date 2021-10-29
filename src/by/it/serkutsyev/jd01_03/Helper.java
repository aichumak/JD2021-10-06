package by.it.serkutsyev.jd01_03;

import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double array[] = new double[10];

        for (int i = 0; i < 10; i++) {
            array[i] = sc.nextDouble();
        }
        double minimalValue = findMin(array);
        double maximumValue = findMax(array);
        System.out.println(minimalValue);
        System.out.println(maximumValue);
        sort(array);
        System.out.println();
        double[][] matrix = new double[3][3];
        System.out.println("Введите матрицу для перемножения с вектором:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5.2f", matrix[i][j]);
                ;
            }
            System.out.println();
        }

        double[] vector = new double[3];
        System.out.println("Введите вектор для перемножения с матрицей:");
        for (int i = 0; i < 3; i++) {
            vector[i] = sc.nextDouble();
        }
        double[][] matrixLeft = new double[2][2];
        System.out.println("Введите первую матрицу для перемножения с матрицей:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixLeft[i][j] = sc.nextDouble();
            }
        }
        double[][] matrixRight = new double[2][2];
        System.out.println("Введите вторую матрицу для перемножения с матрицей:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixRight[i][j] = sc.nextDouble();
            }
        }
        double[] multiplicationMatrixVector = multiply(matrix, vector);
        for (int i = 0; i < multiplicationMatrixVector.length; i++) {
                System.out.printf("%5.2f", multiplicationMatrixVector[i]);
                ;

            System.out.println();
        }
        double[][] multiplicationMatrixMatrix = multiply(matrixLeft, matrixRight);
        System.out.println("Результат перемножения 2 матриц:");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%7.1f",multiplicationMatrixMatrix[i][j]);;
            }
            System.out.println();
        }

    }

    static double findMin(double[] array) {
        double minimalElement = array[0];
        if (array.length == 0) {
            return Double.MIN_VALUE;
        } else {
            for (double i : array) {
                if (minimalElement > i) {
                    minimalElement = i;
                }

            }
            return minimalElement;
        }
    }

    static double findMax(double[] array) {
        double maximalElement = array[0];
        if (array.length == 0) {
            return Double.MAX_VALUE;
        } else {
            for (double i : array) {
                if (maximalElement < i) {
                    maximalElement = i;
                }

            }
            return maximalElement;
        }
    }

    public static void sort(double[] array) {
        int arrayIndexes = array.length - 1;
        boolean transposition;
        do {
            transposition = false;
            for (int i = 0; i < arrayIndexes; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    transposition = true;
                }
            }
            arrayIndexes--;
        }
        while (transposition);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double [] vectorResult = new double [matrix.length];
        for (int i = 0; i< matrix.length; i++){
            for (int j = 0; j < vector.length; j++) {
                vectorResult[i]= vectorResult[i]+matrix[i][j]*vector[j];

            }
        }
        return vectorResult;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
       double matrixResult [][] = new double [matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                  matrixResult[i][j]=matrixResult[i][j] + matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return matrixResult;

    }
}

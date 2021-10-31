package by.it.laevskiy.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (double v : array) {
            if (v < min)
                min = v;
        }
        return min;
    }

    static double findMax(double[] array) {
        double max;
        Arrays.sort(array);
        max = array[array.length - 1];
        return max;
    }

    static void sort(double[] array) {
        int j;
        boolean flag = true;
        double temp;

        while (flag) {
            flag = false;
            for (j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }

    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return z;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return z;
    }

}
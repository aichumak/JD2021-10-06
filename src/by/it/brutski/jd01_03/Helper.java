package by.it.brutski.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = - Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[0] = min;
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = - Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[0] = max;
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    static void sort(double[] array) {
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    double x = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = x;
                    flag = true;
                }
            }
        }while (flag);

        for(double element : array){
            System.out.print(element + " ");
        }
    }

    static double[] multiply(double[][] matrix, double[] vector){
        double[] matrix_vector = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {

                matrix_vector[i] = matrix_vector[i] + matrix[i][j] * vector[j];
            }
        }
        return matrix_vector;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] matrixLeft_Right = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {

                    matrixLeft_Right[i][j] = matrixLeft_Right[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrixLeft_Right;
    }
}

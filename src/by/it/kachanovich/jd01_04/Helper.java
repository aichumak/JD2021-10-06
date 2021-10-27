package by.it.kachanovich.jd01_04;

class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (double v : array) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (double v : array) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    static double[] sort(double[] array) {
        double numMin;
        int numJ;
        double[] arrayResult = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            numMin = array[i];
            numJ = i;
            for (int j = i; j < array.length; j++) {
                if (numMin > array[j]) {
                    numMin = array[j];
                    numJ = j;
                }
            }
            array[numJ] = array[i];
            array[i] = numMin;
            arrayResult[i] = array[i];
        }
        return arrayResult;
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] multArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                multArray[i] += matrix[i][j] * vector[j];
            }
        }
        return multArray;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] multArray = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            return null;
        }
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    multArray[i][j] = multArray[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }

            }

        }
        return multArray;
    }
}

package by.it.chumak.jd01_04;

public class Helper {
    static double findMin(double[] arrayDoubleNumbers) {
        double minValue = arrayDoubleNumbers[0];

        for (double element : arrayDoubleNumbers) {
            if (minValue > element) {
                minValue = element;
            }
        }
        return minValue;
    }

    static double findMax(double[] arrayDoubleNumbers) {
        double maxValue = arrayDoubleNumbers[0];

        for (double element : arrayDoubleNumbers) {
            if (maxValue < element) {
                maxValue = element;
            }
        }
        return maxValue;
    }

    static void sort(double[] arrayDoubleNumbers) {
        boolean sorted;
        int lastArrayIndex = arrayDoubleNumbers.length - 1;

        do {
            sorted = false;
            for (int i = 0; i < lastArrayIndex; i++) {
                if (arrayDoubleNumbers[i] > arrayDoubleNumbers[i + 1]) {
                    double temporaryValueStorage = arrayDoubleNumbers[i];
                    arrayDoubleNumbers[i] = arrayDoubleNumbers[i + 1];
                    arrayDoubleNumbers[i + 1] = temporaryValueStorage;
                    sorted = true;
                }
            }
        } while (sorted);
    }

    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector) {
        double[] z = new  double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }            
        }
        return z;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] z = new  double[matrixLeft.length][matrixRight[0].length];
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

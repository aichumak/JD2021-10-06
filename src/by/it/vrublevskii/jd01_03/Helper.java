package by.it.vrublevskii.jd01_03;

class Helper {


    static double findMin(double[] array) {

        double arrayMinValue = array[0];

        for (double arrayElement : array) {
            if (arrayMinValue > arrayElement) {
                arrayMinValue = arrayElement;
            }
        }

        return arrayMinValue;
    }

    static double findMax(double[] array) {

        double arrayMaxValue = array[0];

        for (double arrayElement : array) {
            if (arrayMaxValue < arrayElement) {
                arrayMaxValue = arrayElement;
            }
        }

        return arrayMaxValue;
    }

    static void sort(double[] array) {

        double bufferValue;
        int arrayLength = array.length;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (array[j] > array[j + 1]) {
                    bufferValue = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = bufferValue;
                }
            }
            arrayLength -= 1;
        }

        for (double arrayElement : array) {
            System.out.printf("[%- 3.2f] ", arrayElement);
        }

        System.out.println();
    }


    static double[] multiply(double[][] matrix, double[] vector) {

        double[] result = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        System.out.println("Результат умножения матрицы на вектор:");
        for (double matrixElement : result) {
            System.out.printf("%7.2f", matrixElement);
        }

        System.out.println();
        return result;
    }

    static double[][] multiply(double[][] leftMatrix, double[][] rightMatrix) {

        double[][] result = new double[leftMatrix.length][rightMatrix[0].length];
        int sharedCount = rightMatrix.length;

        for (int i = 0; i < leftMatrix.length; i++) {
            for (int j = 0; j < rightMatrix[0].length; j++) {
                for (int k = 0; k < sharedCount; k++) {
                    result[i][j] += leftMatrix[i][k] * rightMatrix[k][j];
                }
            }
        }

        for (int i = 0; i < leftMatrix.length; i++) {
            for (int j = 0; j < rightMatrix[0].length; j++) {
                System.out.printf("%10.2f", result[i][j]);
            }
            System.out.println();
        }

        return result;
    }
}

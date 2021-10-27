package by.it.kanaplianik.jd01_04;

public class Helper {
    static double findMax (double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
        return max;
    }
     static double findMin(double[] array) {
        double min = array[0];
         for (int i = 0; i < array.length; i++) {
             if (array[i] < min) {
                 min = array[i];
             }
         }
         System.out.println(min);
        return min;
     }
    static void sort(double[ ] array) {
        double temporaryValue = 0;
        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i <= array.length-2-k; i++) {
                if (array[i] > array[i+1]) {
                    temporaryValue = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temporaryValue;
                }
            }
        }
        InOut.printArray(array);
    }
    static double[ ] multiply(double[ ][ ] matrix, double[ ] vector) {
        double[] vectorResult = new double[matrix.length];
        for (int i = 0; i <= matrix.length-1; i++) {
            for (int j = 0; j <= matrix[i].length-1; j++) {
                vectorResult [i] = vectorResult[i] + (matrix[i][j] * vector[j]);
            }
        }
        return vectorResult;
    }
}

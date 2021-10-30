package by.it.astapchik.jd01_04;

public class Helper {
    static double findMin(double[] array){
        double min = array[0];
        for (double i : array) {
            if(i<min){
                min = i;
            }
        }
        System.out.println(min);
        return min;
    }
    static double findMax(double[] array){
        double max = array[0];
        for (double i : array) {
            if (i > max){
                max = i;
            }
        }
        System.out.println(max);
        return max;
    }

    static void sort(double[ ] array) {
//        Arrays.sort(array);
        boolean flag;
        double lastElement = array.length-1;
        do {
            flag = false;
            for (int i = 0; i < lastElement; i++) {
                if(array[i] > array[i+1]){
                     double buffer = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buffer;
                    flag = true;
                }
            }
            lastElement-- ;
        }
        while (flag);
        for (double y : array){
            System.out.print(y + "  ");
        }
    }

    static double[] multiply(double[ ][ ] matrix, double[ ] vector){
        double[ ] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    static double[ ][ ] multiply(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[ ][ ] matrixResult = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixResult[i][j] = matrixResult[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrixResult;
    }

}

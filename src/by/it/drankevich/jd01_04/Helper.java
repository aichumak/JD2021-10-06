package by.it.drankevich.jd01_04;

public class Helper {

    static double findMin(double[] array) {
        if (array.length==0) {
            return Integer.MIN_VALUE;
        }
        else {
            double min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                }

            }
            return min;
        }
    }

    static double findMax(double[] array) {
        if (array.length==0) {
            return Integer.MAX_VALUE;
        }
        else {
            double max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;

        }
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int m=i;
            for (int j = i+1; j < array.length; j++) {
                if (array[m] > array[j]) {
                    m = j;
                }
            }
            double t=array[m];
            array[m]=array[i];
            array[i]=t;
        }

    }

    static void sortbubble (double[] array) {
        boolean swap;
        int last= array.length-1;
        do {
            swap=false;
            for (int i = 0; i < last; i++) {
                int m = i;
                if (array[m] > array[i + 1]) {
                    m = i + 1;
                    double t = array[m];
                    array[m] = array[i];
                    array[i] = t;
                    swap=true;
                }
            }
        }while (swap);



    }

    static double [] multiply(double[][] matrix, double[] vector) {
        double [] newvector= new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newvector[i]=newvector[i]+matrix[i][j]* vector[j];
            }

        }
     return newvector;
    }

    static double [][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double [][] newmatrix= new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newmatrix[i][j]=newmatrix[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }

            }

        }

        return newmatrix;
    }
}

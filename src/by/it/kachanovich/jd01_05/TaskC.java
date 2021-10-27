package by.it.kachanovich.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.pow;

class TaskC {
    public static void main(String[] args) {
//        step1();
        step2();
    }

    private static void step1() {
        Random ran = new Random();
        final double INTERVAL = 9 + 5.33;
        int numArrayElements = ran.nextInt(20, 40);
        double step = INTERVAL / (numArrayElements - 1);
        double[] array = new double[numArrayElements];
        int i = 0;
        for (double x = -5.33; x <= 9; x += step) {
            array[i] = pow(pow(x, 2) + 4.5, 1 / 3.0);
            i++;
        }
        System.out.printf("Массив A[]\n");
        for (int j = 0; j < array.length; j++) {
            if (j % 5 == 0 & j != 0) {
                System.out.println();
            }
            System.out.printf("  A[%3d] = %.5f    ", j, array[j]);

        }
        System.out.println();
        System.out.printf("Массив B[] из элементов массива A > 3.5\n");
        i = 0;
        for (int j = 0; j < array.length; j++) {
//            if (j % 5 == 0 & j != 0) {
//                System.out.println();
//            }
            if (array[j] > 3.5) {
                if (i % 5 == 0 & i != 0) {
                    System.out.println();
                }
                System.out.printf("  B[%3d] = %.5f    ", i, array[j]);
                i++;
            }
        }
    }


    private static void step2() {
        double[] arrayA = new double[31];
        double[] arrayTemporary = new double[31];
        double[] arrayB;
        int j = 0;
        Random ran = new Random();
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = ran.nextDouble(103.0, 450.0);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] * 0.1 > i) {
                arrayTemporary[i] = arrayA[i];
                j++;
            }
        }
        arrayB = new double[j];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = arrayTemporary[i];
        }
        Arrays.sort(arrayB);
        for (int i = 0; i < arrayA.length / 2; i++) {

            System.out.printf("  B[%3d] = %.2f     B[%3d] = %.2f", i, arrayB[i], (arrayB.length / 2) + i, arrayB[(arrayB.length / 2) + i]);
            System.out.println();
        }
    }
}

package by.it.vrublevskii.jd01_03;

import java.util.Scanner;

class InOut {

    static double[] getArray(String line) {

        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] doubleValues = new double[stringValues.length];

        for (int i = 0; i < stringValues.length; i++) {
            doubleValues[i] = Double.parseDouble(stringValues[i]);
        }

        return doubleValues;
    }


    static double[][] getMatrix(int stringCount){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первую строку матрицы:");
        String line = sc.nextLine();
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[][] doubleMatrix = new double[stringCount][stringValues.length];

        for (int i = 0; i < stringValues.length; i++) {
            doubleMatrix[0][i] = Double.parseDouble(stringValues[i]);
        }

        return fillMatrix(doubleMatrix, stringCount, stringValues.length);
    }


    static double[][] fillMatrix(double[][] matrix, int stringCount, int columnCount) {

        Scanner sc = new Scanner(System.in);
        String line;
        String[] stringValues;

        for (int i = 1; i < stringCount; i++) {
            System.out.println("Введите следующую строку матрицы:");
            line = sc.nextLine();
            line = line.trim();
            stringValues = line.split(" ");

            for (int j = 0; j < stringValues.length; j++) {
                matrix[i][j] = Double.parseDouble(stringValues[j]);
            }

        }

        System.out.println("Matrix:");

        for (int i = 0; i < stringCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("%5.2f", matrix[i][j]);
            }
            System.out.println();
        }

        return matrix;
    }







    static void printArray(double[] array) {

        for (double arrayElement : array) {
            System.out.printf("%-9.2f", arrayElement);
        }

        System.out.println();
    }


    static void printArray(double[] array, String name, int columnCount) {

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d] = %-10.4f", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
    }

}

package by.it.serkutsyev.jd01_03;

import java.util.Scanner;

public class InOut {
   String line;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        getArray(line);
        InOut object = new InOut();
        double array[] = object.getArray(line);
        printArray(array);
        int columnCount = 3;
        String name = "ArrayA3";
        printArray(array, name, columnCount);
    }

    static double[] getArray(String line) {
        line = line.trim();
        String[] elementString = line.split(" ");
        double[] arrayFromString = new double[elementString.length];
        for (int i = 0; i < elementString.length; i++) {
            arrayFromString[i] = Double.parseDouble(elementString[i]);
        }

        return arrayFromString;
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void printArray(double array[], String name, int columnCount) {
        int elementNumber = 0;

        for (int j = 0; j < array.length; j++) {
            System.out.printf("%2$s[%1$ -3d]=%3$-7.2f", j, name, array[j]);
            elementNumber++;
            if ((elementNumber % columnCount == 0) || (array.length - 1 == j)){
                System.out.println();

            }
        }

    }
}

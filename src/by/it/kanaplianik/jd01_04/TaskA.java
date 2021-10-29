package by.it.kanaplianik.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        buildOneDimArray(string);
    }

    static void printMulTable() {
        for (int a = 2; a <= 9; a++) {
            for (int b = 2; b <= 9; b++) {
                int c = a * b;
                System.out.printf("%1d*%1d=%-2d ", a, b, c);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstValue = array[0];
        double lastValue = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstValue) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
            for (int i = 0; i < array.length; i++) {
            if (array[i] == lastValue) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
}

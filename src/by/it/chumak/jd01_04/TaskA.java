package by.it.chumak.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] arrayRealNumbers = InOut.getArray(line);
        double firstValue = arrayRealNumbers[0];
        double lastValue = arrayRealNumbers[arrayRealNumbers.length - 1];

        InOut.printArray(arrayRealNumbers, "V", 5);
        System.out.println();
        Helper.sort(arrayRealNumbers);
        InOut.printArray(arrayRealNumbers, "V", 4);

        System.out.printf("Index of first element=%d", Arrays.binarySearch(arrayRealNumbers, firstValue));
        System.out.println();
        System.out.printf("Index of last element=%d", Arrays.binarySearch(arrayRealNumbers, lastValue));
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1$d*%2$d=%3$-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }
}

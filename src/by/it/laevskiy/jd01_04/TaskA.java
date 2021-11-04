package by.it.laevskiy.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        sort(array);

        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }


    }

    static void sort(double[] array) {
        int j;
        boolean flag = true;
        double temp;

        while (flag) {
            flag = false;
            for (j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp =array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }

    }
}
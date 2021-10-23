package by.it.vrublevskii.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

class TaskA {

    static void main(String[] args) {

        printMulTable();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);


    }

    static void printMulTable() {

        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, (i * j));
            }
            System.out.println();
        }
        System.out.println();

    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElementValue = array[0];
        double lastElementValue = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int indexFirstElement = Arrays.binarySearch(array, firstElementValue);
        int indexLastElement = Arrays.binarySearch(array, lastElementValue);
        System.out.printf("Index of the first element=%d\n", indexFirstElement);
        System.out.printf("Index of the last element=%d\n", indexLastElement);
    }

}

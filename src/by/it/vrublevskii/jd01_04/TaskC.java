package by.it.vrublevskii.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {
    static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        mergeSort(buildOneDimArray(line));
//        double[] array = {2, 9, 1, 5, 7, 4, 3, 6, 5};
        double[] array = {9, 2, 5, 1};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
        System.out.println();
        mergeSort(array);

    }

    static double[] buildOneDimArray(String line) {
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
        return array;
    }

    static void mergeSort(double[] array) {


        int partArray = array.length >> 1;
        double buffer = 0;
//        while (partArray > 2) {
//            partArray = partArray >> 1;
//        }
        for (int i = 0; i < array.length; i = i + 2) {
            if ((i < array.length-1) && (array[i] > array[i + 1])) {
                buffer = array[i];
                array[i] = array[i + 1];
                array[i + 1] = buffer;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
    }
}

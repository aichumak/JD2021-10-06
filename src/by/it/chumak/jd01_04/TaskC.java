package by.it.chumak.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
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
        mergeSort(arrayRealNumbers);
        InOut.printArray(arrayRealNumbers, "V", 4);

        System.out.printf("Index of first element=%d", binarySearch(arrayRealNumbers, firstValue));
        System.out.println();
        System.out.printf("Index of last element=%d", binarySearch(arrayRealNumbers, lastValue));
    }

    static void mergeSort(double[] arrayRealNumbers) {
        mergesort(arrayRealNumbers, 0, arrayRealNumbers.length - 1);
    }

    private static void mergesort(double[] input, int initialIndex, int lastIndex) {

        int mid = (initialIndex + lastIndex) / 2;
        if (initialIndex < lastIndex) {
            mergesort(input, initialIndex, mid);
            mergesort(input, mid + 1, lastIndex);
        }

        int i = 0, firstPoint = initialIndex, lastPoint = mid + 1;
        double[] tmp = new double[lastIndex - initialIndex + 1];

        while (firstPoint <= mid && lastPoint <= lastIndex) {
            tmp[i++] = input[firstPoint] < input[lastPoint] ? input[firstPoint++] : input[lastPoint++];
        }
        while (firstPoint <= mid) {
            tmp[i++] = input[firstPoint++];
        }
        while (lastPoint <= lastIndex) {
            tmp[i++] = input[lastPoint++];
        }
        i = 0;
        while (initialIndex <= lastIndex) {
            input[initialIndex++] = tmp[i++];
        }
    }

    static int binarySearch(double[] array, double value) {
        int firstPoint = 0;
        int lastPoint = array.length - 1;
        int midPoint;

        while (firstPoint <= lastPoint) {
            midPoint = (firstPoint + lastPoint) / 2;
            if (array[midPoint] > value) {
                lastPoint = midPoint - 1;
            } else if (array[midPoint] < value) {
                firstPoint = midPoint + 1;
            } else {
                return midPoint;
            }
        }
        return -1;
    }
}
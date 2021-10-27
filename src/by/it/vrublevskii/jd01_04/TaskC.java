package by.it.vrublevskii.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println();
        double[] array = buildOneDimArray(line);
        Arrays.sort(array);
    }

    static double[] buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElementValue = array[0];
        double lastElementValue = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int indexFirstElement = binarySearch(array, firstElementValue);
        int indexLastElement = binarySearch(array, lastElementValue);
        System.out.printf("Index of the first element=%d\n", indexFirstElement);
        System.out.printf("Index of the last element=%d\n", indexLastElement);
        return array;
    }

    static int binarySearch(double[] array, double value) {
        int minIndex = 0;
        int maxIndex = array.length - 1;
        int mid = maxIndex >> 1;
        do{
            if (array[minIndex] == value) {
                return minIndex;
            } else if (array[maxIndex] == value) {
                return maxIndex;
            } else if (array[mid] == value) {
                return mid;
            }else{
                if (value < array[mid]) {
                    minIndex += 1;
                    maxIndex = mid - 1;
                    mid =  1 + ((maxIndex - minIndex) >> 1);
                }else{
                    minIndex = mid + 1;
                    maxIndex -= 1;
                    mid = minIndex + ((maxIndex - minIndex) >> 1);
                }
            }
        }while (true);
    }
}

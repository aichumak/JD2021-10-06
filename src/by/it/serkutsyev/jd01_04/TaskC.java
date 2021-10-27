package by.it.serkutsyev.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }


    static void buildOneDimArray(String line) {
        line = line.trim();
        String name = "V";
        int columnCount = 5;
        String[] elementString = line.split(" ");
        double[] arrayFromString = new double[elementString.length];
        for (int i = 0; i < elementString.length; i++) {
            arrayFromString[i] = Double.parseDouble(elementString[i]);
        }
        double firstElement = arrayFromString[0];
        double lastElement = arrayFromString[arrayFromString.length - 1];

        int elementNumber = 0;

        for (int j = 0; j < arrayFromString.length; j++) {
            System.out.printf("%2$s[%1$ -3d]=%3$-7.2f", j, name, arrayFromString[j]);
            elementNumber++;
            if ((elementNumber % columnCount == 0) || (arrayFromString.length - 1 == j)) {
                System.out.println();
            }

        }
        System.out.println();

        int arrayIndexes = arrayFromString.length - 1;
        boolean transposition;
        do {
            transposition = false;
            for (int i = 0; i < arrayIndexes; i++) {
                if (arrayFromString[i] > arrayFromString[i + 1]) {
                    double buffer = arrayFromString[i];
                    arrayFromString[i] = arrayFromString[i + 1];
                    arrayFromString[i + 1] = buffer;
                    transposition = true;
                }
            }
            arrayIndexes--;
        }
        while (transposition);

        int secondColoumnCount = 4;
        int secondElementNumber = 0;

        for (int j = 0; j < arrayFromString.length; j++) {
            System.out.printf("%2$s[%1$ -3d]=%3$-7.2f", j, name, arrayFromString[j]);
            secondElementNumber++;
            if ((secondElementNumber % secondColoumnCount == 0) || (arrayFromString.length - 1 == j)) {
                System.out.println();
            }
        }

//        for (int i = 0; i < arrayFromString.length; i++) {
//            if (arrayFromString[i]==firstElement){
//                System.out.println("Index of first element=" + i);
//            }
//            else if (arrayFromString[i]==lastElement){
//                System.out.println("Index of last element=" + i);
//            }
//        }

        int indexFirstBinary = binarySearch(arrayFromString, firstElement);
        System.out.println("Index of first element=" + indexFirstBinary);

        int indexLastBinary = binarySearch(arrayFromString, lastElement);
        System.out.println("Index of last element=" + indexLastBinary);

    }

    static int binarySearch(double[] array, double value) {
        int first = 0;
        int last = array.length - 1;
        int index = 0;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (array[middle] == value) {
                index = middle;
                break;
            } else if (array[middle] > value) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }


        }
        return index;
    }
}

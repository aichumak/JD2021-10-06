package by.it.serkutsyev.jd01_04;

import by.it.serkutsyev.jd01_03.Helper;
import by.it.serkutsyev.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }



    static void printMulTable() {
        int multiplicator1 = 2;
        for (int i = 0; i < 8; i++) {
            int multiplicator2 = 2;
            for (int j = 0; j < 8; j++) {
                System.out.printf("%-1d*%-1d=%-3d", multiplicator1, multiplicator2, multiplicator1 * multiplicator2);
                multiplicator2++;
            }
            System.out.println();
            multiplicator1++;
        }
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
        double firstElement = arrayFromString [0];
        double lastElement = arrayFromString [arrayFromString.length-1];

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

        for (int i = 0; i < arrayFromString.length; i++) {
            if (arrayFromString[i]==firstElement){
                System.out.println("Index of first element=" + i);
            }
            else if (arrayFromString[i]==lastElement){
                System.out.println("Index of last element=" + i);
            }
        }


    }
}

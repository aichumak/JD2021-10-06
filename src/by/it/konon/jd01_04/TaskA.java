package by.it.konon.jd01_04;

import java.util.Scanner;

public class TaskA {


    static void printMulTable() {

        for (int i = 2; i <= 9; i++) {
            int count = 0;
            for (int j = 2; j <= 9; j++) {
                count++;
                System.out.printf("%d*%d=%-3d", i, j, i * j);
                if (count % 8 == 0) {
                    System.out.println();

                }
            }

        }


    }

    static void buildOneDimArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("%s[%d]=%2.4f  ", "V", i, result[i]);


        }
        boolean sort = false;
        double place = 0;
        while (!sort) {
            sort = true;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    place = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = place;
                    sort = false;
                }
            }

        }
        System.out.println();

        for (int i = 0; i < result.length; i++) {
            if (i % 4 == 0) {
                System.out.println();
            }
            System.out.printf("%s[%d]=%-2.4f\t", "V", i, result[i]);

        }
        System.out.println();
        double firstElement = result[0];
        double lastElement = result[result.length - 1];
        for (int i = 0; i < result.length; i++) {
            if (firstElement == result[i]) {
                System.out.println("first element" + "=" + i);
                break;
            }

        }

        for (int i = 0; i < result.length; i++) {
            if (lastElement == result[i]) {
                System.out.println("last element" + "=" + i);
                break;
            }

        }

    }

    public static void main(String[] args) {


        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        buildOneDimArray(string);


    }

}



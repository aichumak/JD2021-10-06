package by.it.brutski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%-1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] strings = line.split(" ");

        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }

        for (double element : array) {
            System.out.print(Arrays.toString(new double[]{element}));
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%-1d] = %-3.2f ", "V", i, array[i]);
        }

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}


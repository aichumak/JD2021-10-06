package by.it._tasks_.kachanovich.jd01_02;


import java.util.Random;
import java.util.Scanner;

class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        step1(n);
        step2(arr);
        step3(arr);
    }

     static int[][] step1(int n) {
        int[][] array = new int[n][n];
        Random ran = new Random();
        int minNum = 0, maxNum = 0;

        do {
            for (int i = 0; i < n; i++) {
                if (minNum == -n & maxNum == n)
                    break;
                for (int j = 0; j < n; j++) {
                    array[i][j] = ran.nextInt(-n, n + 1);
                    if (array[i][j] == -n)
                        minNum = -n;
                    if (array[i][j] == n)
                        maxNum = n;
                    if (minNum == (-n) & maxNum == n)
                        break;
                }
            }
        }
        while ((minNum != (-n)) & (maxNum != n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    static int step2(int[][] array) {
        int sum = 0;
        int n;
        for (int[] ints : array) {
            n = 0;
            for (int anInt : ints) {
                if (anInt > 0 & n != 1) {
                    n++;
                } else if (anInt > 0 & n == 1) {
                    n--;
                }
                if (anInt < 0 & n == 1) {
                    sum += anInt;
                }

            }
        }
        return sum;
    }

    static int[][] step3(int[][] array) {
        int maxNumArray = array[0][0];
        int numMaxElement = 0;

        for (int[] ints : array) {
            for (int anInt : ints) {
                if (maxNumArray < anInt) {
                    maxNumArray = anInt;
                }
            }
        }
        // находим количество максимальных элементов массива
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (maxNumArray == anInt) {
                    numMaxElement++;
                }
            }
        }


        int[][] arrayCoordinates = new int[numMaxElement][2];
        int i1 = 0, j1 = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == maxNumArray) {
                    arrayCoordinates[i1][j1] = i;
                    arrayCoordinates[i1][j1 + 1] = j;
                    i1++;
                }
            }
        }


        int newNumI = array.length;
        int newNumJ = array[0].length;
        if (arrayCoordinates.length > 0) {
            newNumI--;
            for (int i = 1; i < arrayCoordinates.length; i++) {
                if (arrayCoordinates[i][0] != arrayCoordinates[i - 1][0]) {
                    newNumI--;
                }
            }
        }
        if (arrayCoordinates[0].length > 0) {
            newNumJ--;
            for (int i = 1; i < (arrayCoordinates.length); i++) {
                if (arrayCoordinates[i][1] != arrayCoordinates[i - 1][1]) {
                    newNumJ--;
                }
            }
        } else return null;


        int[][] newArr = new int[newNumI][newNumJ];
        i1 = 0;

        int i2 = 0, j2 = 0;
        boolean b1;
        for (int i = 0; i < array.length; ) {
            b1 = false;
            while (i1 < arrayCoordinates.length) {
                if (i == arrayCoordinates[i1][0]) {
                    i++;
                    b1 = true;
                    break;
                }
                i1++;
            }
            if (b1) {
                i1 = 0;
                continue;
            }
            i1 = 0;
            for (int j = 0; j < array[i].length; ) {
                b1 = false;
                while (i1 < arrayCoordinates.length) {
                    if (j == arrayCoordinates[i1][1]) {
                        j++;
                        b1 = true;
                        break;
                    }
                    i1++;

                }
                if (b1) {
                    i1 = 0;
                    continue;
                }
                newArr[i2][j2] = array[i][j];
                j2++;
                i1 = 0;
                j++;
            }
            i++;
            i2++;
            j2 = 0;
        }

        return newArr;
    }
}

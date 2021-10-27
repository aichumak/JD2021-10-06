package by.it.vrublevskii.jd01_02;

import java.util.Scanner;

class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = step1(n);
        step2(arr);
        step3(arr);
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        int alarmMax, alarmMin;

        do {
            alarmMax = 0;
            alarmMin = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (arr[i][j] == n) {
                        alarmMax = 1;
                    } else if (arr[i][j] == -n) {
                        alarmMin = 1;
                    }
                }
            }
        } while (alarmMax == 0 || alarmMin == 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.print("\n");
        }

        return (arr);
    }

    private static int step2(int[][] arr) {
        int n = arr.length;
        int sum = 0;
        int counter;
        for (int[] ints : arr) {
            counter = 0;
            for (int j = 0; j < n; j++) {
                    if ((ints[j] > 0) && (counter == 0)) {
                        counter = 1;
                    } else if ((ints[j] <= 0) && (counter == 1)) {
                        sum += ints[j];
                    } else if ((ints[j] > 0) && (counter == 1)) {
                        break;
                    }
            }
        }

        System.out.println(sum);
        return (sum);
    }

    private static int[][] step3(int[][] arr) {
        int n = arr.length;
        int[] indexI = new int[n];
        int[] indexJ = new int[n];
        int newMaxI = n;
        int newMaxJ = n;
        int newI = 0;
        int newJ = 0;
        int maxValue = arr[0][0];

        for (int[] ints : arr) {
            for (int j = 0; j < n; j++) {
                if (maxValue < ints[j]) {
                    maxValue = ints[j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == maxValue) {
                    indexI[i] = 1;
                    if (indexJ[j] == 0) {
                        indexJ[j] = 1;
                        newMaxJ--;
                    }
                }
            }
            if (indexI[i] == 1) {
                newMaxI--;
            }
        }
        int[][] newArr = new int[newMaxI][newMaxJ];

        for (int i = 0; i < n; i++) {
            if (indexI[i] == 0) {
                for (int j = 0; j < n; j++) {
                    if (indexJ[j] == 0) {
                        newArr[newI][newJ] = arr[i][j];
                        System.out.printf("%5d", newArr[newI][newJ]);
                        newJ++;
                    }
                }
                newI++;
                newJ = 0;
                System.out.print("\n");
            }
        }

        return newArr;
    }
}

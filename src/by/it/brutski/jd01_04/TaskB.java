package by.it.brutski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.next();
        }

        int[][] zp = new int[n][4];
        for (int i = 0; i < n; i++) {

            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            int total = 0;
            System.out.printf("%-15s",name[i]);

            for (int j = 0; j < 4; j++) {
                total += zp[i][j];
                System.out.printf("%-10d", zp[i][j]);
            }
            System.out.printf("%-10d", total);
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sum += zp[i][j];
            }
        }
        System.out.printf("%-15s%-10d", "Итого", sum);
        System.out.println();

        double sr = (double) sum / (n * 4);
        System.out.printf("%-15s%-10.4f", "Средняя", sr);
        System.out.println();
    }
}

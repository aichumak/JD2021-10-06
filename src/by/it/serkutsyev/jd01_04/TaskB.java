package by.it.serkutsyev.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String surnames[] = new String[n];

        for (int i = 0; i < n; i++) {
            surnames[i] = sc.next();

        }
        int[][] salaries = new int[n][4];
        String name = surnames[0];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = sc.nextInt();
            }

        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s", surnames[i]);
            int sumRow = 0;
            for (int j = 0; j < 4; j++) {
                sumRow = sumRow + salaries[i][j];
                System.out.printf("%-10d", salaries[i][j]);
                if (j == 3) {
                    System.out.printf("%-5d", sumRow);
                    System.out.println();
                }
            }

        }
        System.out.println("-------------------------------------------------------");
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                sumTotal = sumTotal + salaries[i][j];

            }
        }
       int numberQuarter = 4*n;
        double averageQuarterly = (double)sumTotal/numberQuarter ;
        System.out.printf("%-10s%-10d","Итого",sumTotal);
        System.out.println();
        System.out.printf("%-10s%-10.6f","Средняя",averageQuarterly);



    }
}

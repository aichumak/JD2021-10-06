package by.it.chumak.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countEmployees = sc.nextInt();
        int[][] arraySalary = new int[countEmployees][4];
        int qSumSalary, SumSalary = 0;
        String[] arraySurnames = new String[countEmployees];

        for (int i = 0; i < arraySurnames.length; i++) {
            arraySurnames[i] = sc.next();
        }

        for (int i = 0; i < arraySalary.length; i++) {
            System.out.printf("Введите зарплату для %s%n", arraySurnames[i]);
            arraySalary[i][0] = sc.nextInt();
            arraySalary[i][1] = sc.nextInt();
            arraySalary[i][2] = sc.nextInt();
            arraySalary[i][3] = sc.nextInt();
        }

        printTableDividingLine();
        printTableHeader();
        printTableDividingLine();

        for (int i = 0; i < arraySalary.length; i++) {
            qSumSalary = 0;
            System.out.printf("%7s: ", arraySurnames[i]);
            for (int j = 0; j < arraySalary[i].length; j++) {
                System.out.printf("%-8d  ", arraySalary[i][j]);
                qSumSalary = qSumSalary + arraySalary[i][j];
            }
            SumSalary = SumSalary + qSumSalary;
            System.out.printf("%-5d%n", qSumSalary);
        }

        printTableDividingLine();
        System.out.printf("%1$-7s  %2$-8d%n", "Итого", SumSalary);
        System.out.printf("%1$-7s  %2$-20.6f", "Средняя", (double) SumSalary / countEmployees / 4);
    }

    private static void printTableHeader() {
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
    }

    private static void printTableDividingLine() {
        System.out.println("-------------------------------------------------------");
    }
}

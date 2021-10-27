package by.it._tasks_.kachanovich.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] surname = new String[n];
        for (int i = 0; i < n; i++) {
            surname[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Введите зарплату для %s\n",surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int sumSalary;
        double sumAllSalary=0.0;
        System.out.print("-----------------------------------------------------------\n");
        System.out.print("Фамилмя   Квартал1   Квартал2   Квартал3   Квартал4   Итого\n");
        System.out.print("-----------------------------------------------------------\n");
        for (int i = 0; i < salary.length; i++) {
            sumSalary =0;
            System.out.printf("%-10s",surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-11d", salary[i][j]);
                sumSalary+=salary[i][j];
            }
            System.out.printf("%-3d\n",sumSalary);
            sumAllSalary += sumSalary;
        }
        System.out.print("-----------------------------------------------------------\n");
        System.out.printf("Итого %-4.0f\n", sumAllSalary);
        double salaryAverage = sumAllSalary/(salary.length * salary[0].length);
        System.out.printf("Средняя %-6.6f\n", salaryAverage);
    }
}

package by.it.laevskiy.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.print("Введите количество людей: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arrayString = new String[n];
        System.out.print("Введите имена: " + "\n");
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = scanner.next();
        }

        int[][] arraySalary = new int[n][4];
        for (int i = 0; i < arraySalary.length; i++) {

            System.out.println("Введите зарплату для " + arrayString[i]);
            for (int j = 0; j < arraySalary[0].length; j++) {
                arraySalary[i][j] = scanner.nextInt();
            }
        }

        System.out.printf("%-54s%n", "------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("%-54s%n", "------------------------------------------------------");

        for (int i = 0; i < arraySalary.length; i++) {
            int sum = arraySalary[i][0] + arraySalary[i][1] + arraySalary[i][2] + arraySalary[i][3];
            System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5d%n", arrayString[i], arraySalary[i][0], arraySalary[i][1], arraySalary[i][2], arraySalary[i][3], sum);

        }
        System.out.printf("%-54s%n", "------------------------------------------------------");

        for (int k = 0; k < 1; k++) {
            int sumAll = 0;
            for (int[] ints : arraySalary) {
                sumAll = sumAll + ints[0] + ints[1] + ints[2] + ints[3];

            }
            double midlSalary =(double)sumAll/(n*4);
                    System.out.printf("%-9s%-10d%n", "Итого", sumAll);
            System.out.printf("%-9s%-10.6f%n", "Средняя", midlSalary);
        }


    }
}



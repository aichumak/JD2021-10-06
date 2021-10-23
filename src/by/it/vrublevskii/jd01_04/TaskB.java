package by.it.vrublevskii.jd01_04;

import java.util.Scanner;

public class TaskB {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во человек:");
        int numberPersons = sc.nextInt();
        String[] personsNames = new String[numberPersons];
        for (int i = 0; i < numberPersons; i++) {
            System.out.println("Введите фамилию сотрудника № " + (i + 1));
            personsNames[i] = sc.next();
            System.out.println(personsNames[i]);
        }
        int[][] personsSalary = new int[numberPersons][5];
        int sumSalary;
        for (int i = 0; i < numberPersons; i++) {
            System.out.printf("Введите ЗП за квартал для работника №%d (%s)\n", (i + 1), personsNames[i]);
            sumSalary = 0;
            for (int j = 0; j < 4; j++) {
                personsSalary[i][j] = sc.nextInt();
                sumSalary += personsSalary[i][j];
            }
            personsSalary[i][4] = sumSalary;
        }
        String[] header = {"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%-10s", header[i]);
        }
        System.out.println("\n-------------------------------------------------------");
        for (int i = 0; i < numberPersons; i++) {
            System.out.printf("%7s", personsNames[i]);
            System.out.print("   ");
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10d", personsSalary[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        int quarterTotalSalary = 0;
        for (int i = 0; i < numberPersons; i++) {
            quarterTotalSalary += personsSalary[i][4];
        }
        System.out.printf("Итого     %d\n", quarterTotalSalary);
        double avgSalary = (double) quarterTotalSalary / (numberPersons * 4);
        System.out.printf("Средняя   %.4f\n", avgSalary);
    }
}

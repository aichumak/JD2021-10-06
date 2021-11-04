package by.it.astapchik.jd01_04;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String [] args){
        Scanner sc =  new Scanner(System.in);

        String[] surnames = new String[3];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = sc.nextLine();
        }

        int amount_employees = sc.nextInt();

        int[][] salaries = new int[2][2];

        double resultOfSum = 0;
        double averagePerPerson = 0;
        double averagePerQuartal = 0;

        for (String surname : surnames) {
            System.out.println("Введите зарплату для " + surname);
            for (int i = 0; i < salaries.length; i++) {
                for (int j = 0; j < salaries.length; j++) {
                    salaries[i][j] = sc.nextInt();
                    resultOfSum += salaries[i][j];
                }
            }
        }
        System.out.println("Фамилия " + "Квартал1 "+ "Квартал2 "+ "Квартал3 "+ "Квартал4 "+ "Итог");
        for (String surname : surnames) {
            for (int i = 0; i < salaries.length; i++) {
                for (int j = 0; j < salaries.length; j++) {
                    System.out.print(salaries[i][j]+"  ");
                }
            }
            System.out.println(surname);
        }

//        b2
        averagePerPerson = resultOfSum / amount_employees;
        averagePerQuartal = averagePerPerson / 4;

        double calculateAveragePerQuartal = (double)Math.round(averagePerQuartal * 10000)/10000;

        System.out.println("Итого " + (int)resultOfSum);
        System.out.println("Средняя " + calculateAveragePerQuartal);
    }
}

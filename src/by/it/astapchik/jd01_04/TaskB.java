package by.it.astapchik.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String [] args){
        Scanner input =  new Scanner(System.in);
        int amount_employees = input.nextInt();

        String[] surnames = new String[amount_employees];

        for (int i = 0; i < amount_employees; i++) {
            surnames[i] = input.next();
        }

        int[][] salaries = new int[amount_employees][4];
        int sumPerPerson = 0;
        double resultOfSum = 0;
        double averagePerPerson = 0;
        double averagePerQuartal = 0;
        double calculateAveragePerQuartal = 0;

        for (int i = 0; i < amount_employees; i++) {
            System.out.println("Введите зарплату для " + surnames[i] + "a");
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = input.nextInt();
                resultOfSum += salaries[i][j];
            }

        }
        System.out.printf("%-9s %-9s %-9s %-9s %-9s %-9s%n", "Фамилия", "Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("_______________________________________________________");


        for (int i = 0; i < amount_employees; i++) {
            sumPerPerson = salaries[i][0] + salaries[i][1] +  salaries[i][2] + salaries[i][3];

            averagePerPerson = resultOfSum / amount_employees;
            averagePerQuartal = averagePerPerson / 4;
            calculateAveragePerQuartal = (double)Math.round(averagePerQuartal * 10000)/10000;

            System.out.printf("%-11s %-11s %-11s %-11s %-11s %-7s%n",
                    surnames[i],
                    salaries[i][0],
                    salaries[i][1],
                    salaries[i][2],
                    salaries[i][3],
                    sumPerPerson);
        }

        System.out.println("Итого " + (int)resultOfSum);
        System.out.println("Средняя " + calculateAveragePerQuartal);
    }
}

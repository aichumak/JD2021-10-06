package by.it.kanaplianik.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int workersCount = scanner.nextInt();
        scanner.nextLine();

        String[] namesOfWorkers = new String[workersCount];
        for (int i = 0; i < workersCount; i++) {
            System.out.println("Введите фамилию работника");
            String workerName = scanner.nextLine();
            namesOfWorkers[i] = workerName;
        }

        int[][] salaryTable = new int[workersCount][4];
        for (int i = 0; i < workersCount; i++) {
            System.out.println("Введите зарплату для " + namesOfWorkers[i]);
            String salaryQuartal = scanner.nextLine();
            salaryTable[i] = InOut.getArrayInt(salaryQuartal);
        }

        int[] allSum = new int[workersCount];
        for (int i = 0; i < workersCount; i++) {
            int sum = salaryTable[i][0] + salaryTable[i][1] + salaryTable[i][2] + salaryTable[i][3];
            allSum[i] = sum;
        }

        int totalSum = 0;
        for (int i = 0; i < workersCount; i++) {
            totalSum = totalSum + allSum[i];
        }

        int quartalCount = 4;
        int elementsCount = quartalCount * workersCount;
        double averege = (double)totalSum /(double)elementsCount;

        String dashes = "-------------------------------------------------------------";
        System.out.println(dashes);
        //Фамилия   Квартал1   Квартал2   Квартал3   Квартал4   Итого
        System.out.printf("%-10s%-11s%-11s%-11s%-11s%-7s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(dashes);
        for (int i = 0; i < workersCount; i++) {
            System.out.printf("%-10s%-11s%-11s%-11s%-11s%-7s\n", namesOfWorkers[i], salaryTable[i][0], salaryTable[i][1], salaryTable[i][2], salaryTable[i][3], allSum[i]);
        }
        System.out.println(dashes);
        System.out.printf("%-10s%-11s\n", "Итого", totalSum);
        System.out.printf("%-10s%-11.4f\n", "Средняя", averege);
        System.out.println(dashes);
    }
}

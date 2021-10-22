package by.it.vrublevskii.jd01_04;

import java.util.Scanner;

class InOut {


    static double[] getArray(String line) {
        line = line.trim();
        String[] stringValues = line.split(" ");
        double[] doubleValues = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            doubleValues[i] = Double.parseDouble(stringValues[i]);
        }
        return doubleValues;
    }


    static void printArray(double[] array) {
        for (double arrayElement : array) {
            System.out.printf("%-9.2f", arrayElement);
        }
        System.out.println();
    }


    static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.4f", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i == array.length - 1) {
                System.out.println();
            }
        }
    }


    static String[] getPersons(int numberPersons) {
        Scanner scan = new Scanner(System.in);
        String[] personsNames = new String[numberPersons];
        for (int i = 0; i < numberPersons; i++) {
            System.out.println("Введите фамилию сотрудника № "+(i+1));
            personsNames[i] = scan.next();
        }
        return personsNames;
    }


    static int[][] getSalary(int numberPersons, String[] personsNames) {
        Scanner sc = new Scanner(System.in);
        int[][] salary = new int[numberPersons][4];
        int quarterSalary;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Введите ЗП работника %s\n", personsNames[i]);
            for (int j = 0; j < salary[0].length; j++) {
                quarterSalary = sc.nextInt();
                salary[i][j] = quarterSalary;
            }
        }
        for (int[] onePersonSalaries : salary) {
            for (int persons : onePersonSalaries) {
                System.out.printf("%7d", persons);
            }
            System.out.println();
        }
        return salary;
    }


}

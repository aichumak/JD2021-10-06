package by.it.fomin.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        System.out.println("Введите номер месяца:");
        Scanner userInput = new Scanner(System.in);
        int numberOfMonth = userInput.nextInt();
        step2(numberOfMonth);
        System.out.println("Введите данные a,b,c для решения кв уравнения ");
        double a = userInput.nextInt();
        double b = userInput.nextInt();
        double c = userInput.nextInt();
        step3(a, b, c);

    }

    private static void step1() {
        int N = 5;
        int array[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //  int array[][] = new int[N][N];
        // int fill = 0;
     /*   for (int i = 0; i < N - 1; i++) {
           for (int j = 0; j < N - 1; j++) {

                array[i][j] = array[i][j] + 1;
            }
        }*/
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                if (month < 1 && month > 12)
                    System.out.println("нет такого месяца");
                break;
        }

    }

    private static void step3(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("корней нет");
        } else if (discriminant == 0) {
            double x = -b / 2 * a;
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("корни квадратного уравнения:" + x1 + " " + x2);
        }
    }
}




package by.it.serkutsyev.jd01_02;

import java.util.Scanner;


public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        step1();
        step2(month);
        step3(a, b, c);
    }


    private static void step1() {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        for (int i = 0; i < 25; i++) {
            switch (i) {
                case 4:
                    System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " ");
                    break;
                case 9:
                    System.out.println(arr[5] + " " + arr[6] + " " + arr[7] + " " + arr[8] + " " + arr[9] + " ");
                    break;
                case 14:
                    System.out.println(arr[10] + " " + arr[11] + " " + arr[12] + " " + arr[13] + " " + arr[14] + " ");
                    break;
                case 19:
                    System.out.println(arr[15] + " " + arr[16] + " " + arr[17] + " " + arr[18] + " " + arr[19] + " ");
                    break;
                case 24:
                    System.out.println(arr[20] + " " + arr[21] + " " + arr[22] + " " + arr[23] + " " + arr[24] + " ");
                    break;
            }

        }

    }

    static void step2(int month) {
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
                System.out.println("нет такого месяца");
        }


    }

    static void step3(double a, double b, double c) {
        double root1;
        double root2;
        double discriminant = (b * b) - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("корней нет");
        } else if (discriminant == 0) {
            root1 = (b / (2 * a) * (-1));
            System.out.println(root1);
        } else if (discriminant > 0) {
            root1 = ((-b) + Math.sqrt(b * b + 4 * a * c)) / (2 * a);
            root2 = ((-b) - Math.sqrt(b * b + 4 * a * c)) / (2 * a);
            System.out.println(root1);
            System.out.println(root2);

        }

    }

}


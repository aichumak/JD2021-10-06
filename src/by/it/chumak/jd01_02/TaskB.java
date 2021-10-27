package by.it.chumak.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        step1();
        step2(sc.nextInt());
        step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }

    private static void step3(double nextInt, double nextInt1, double nextInt2) {
        double d = nextInt1 * nextInt1 - 4 * nextInt * nextInt2;

        if (d > 0) {
            double x1 = (-nextInt1 + Math.sqrt(d)) / (2 * nextInt);
            System.out.print(x1 + " ");
            double x2 = (-nextInt1 - Math.sqrt(d)) / (2 * nextInt);
            System.out.println(x2);
        } else if(d<0) {
            System.out.println("корней нет");
        } else {
            double x1 = -nextInt1 / (2 * nextInt);
            System.out.println(x1);
        }
    }

    private static void step2(int nextInt) {
        switch (nextInt) {
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
        System.out.println(nextInt);
    }

    private static void step1() {
        int[][] arrnumbers = new int[5][5];
        int number=1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrnumbers[i][j] = number;
                number = number+1;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                System.out.print(arrnumbers[i][i1] + " ");
            }
            System.out.println();
        }

        }
   }
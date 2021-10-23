package by.it.kanaplianik.jd01_02;

import javax.swing.*;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sccan = new Scanner(System.in);
        step1();
        int x = sccan.nextInt();
        step2(x);
        int a = sccan.nextInt();
        int b = sccan.nextInt();
        int c = sccan.nextInt();
       step3( a, b, c);
    }
    private static void step1() {
        int[][] myArray = {
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9, 10},
                { 11, 12, 13, 14, 15},
                { 16, 17, 18, 19, 20},
                { 21, 22, 23, 24, 25}
        };
        for (int[] row : myArray) {
            for (int el : row){
                System.out.print(el+ " ");
            }
            System.out.println();
        }


    }
    private static void step2(int month) {
        switch (month){
            case (1):
                System.out.println("январь");
                break;
            case (2):
                System.out.println("февраль");
                break;
            case (3):
                System.out.println("март");
                break;
            case (4):
                System.out.println("апрель");
                break;
            case (5):
                System.out.println("май");
                break;
            case (6):
                System.out.println("июнь");
                break;
            case (7):
                System.out.println("июль");
                break;
            case (8):
                System.out.println("август");
                break;
            case (9):
                System.out.println("сентябрь");
                break;
            case (10):
                System.out.println("октябрь");
                break;
            case (11):
                System.out.println("ноябрь");
                break;
            case (12):
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }
    }
    static void step3(double a, double b, double c) {
        Double Dis = b*b-4*a*c;
        if (Dis<0) {
            System.out.println("корней нет");
        }
        else if (Dis==0) {
            Double result = -b/(2*a);
            System.out.println(result);
        }
        else {
            Double DisSqrt = Math.sqrt(Dis);
            Double x1 = (-b+DisSqrt)/(2*a);
            Double x2 = (-b-DisSqrt)/(2*a);
            System.out.println(x1 + " " + x2);
        }
    }

}

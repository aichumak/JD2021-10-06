package by.it.kachanovich.jd01_02;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int month = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step1();
        step2(month);
        step3(a, b, c);
    }
    static void step1(){
        int number= 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                number++;
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    static void step2(int month){
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }

    }
    static void step3(double a, double b, double c){
        double d = (b*b) - (4 * a * c);
        if (d > 0 ){
            System.out.println((-b + Math.sqrt(d))/ (2 * a) + " " + (-b - Math.sqrt(d))/ (2 * a));
        }
        if (d == 0){
            System.out.println(-(b / (2 * a)));
        }
        if (d < 0){
            System.out.println("корней нет");
        }
    }
}

package by.it.serkutsyev.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    static void step1() {
        for (double a = 0; a <= 2; a += 0.20) {
            double y = 0;
            for (double x = 1; x < 7; x++) {
                y = y + pow(7, a) - cos(x);

            }
            // System.out.print(a+" ");
            // System.out.println(y);
            System.out.printf("При a=%2.2f Cумма y = %11.10f\n", a, y);
        }
        System.out.println(" ");
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x += 0.5) {
            double b = 0;
            double a = 0;
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("x/2=%3.2f b=%5.4f a=%5.4f\n", x / 2, b, a);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("x/2=%3.2f b=%5.4f a=%5.4f\n", x / 2, b, a);
            } else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
               // b = pow(1/tan(x),2);
                a = log10(abs(b + 2.74));
                System.out.printf("x/2=%3.2f b=%5.4f a=%5.4f\n", x / 2, b, a);
            } else {
                System.out.printf("x/2=%3.2f Вычисления при данных значениях х/2 невозможны\n", x / 2);
            }
        }
    }
}

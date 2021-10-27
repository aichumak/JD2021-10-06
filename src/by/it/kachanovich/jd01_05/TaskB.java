package by.it.kachanovich.jd01_05;

import static java.lang.Math.*;

class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 0; x <= 6; x++) {
                y += pow(7, a) - cos(x);
                System.out.printf("При a=%.2f Сумма y = %f\n", a, y);
            }
        }
        System.out.println();
    }

    private static void step2() {
        double b = 0, a;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x / 2 <= -1 & x / 2 > -2) {
                b = sin(x*x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2 = %.2f a = %f\n", x / 2, a);
            } else if (x / 2 < 0.2 & x / 2 > -1) {
                b = cos(x*x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2 = %.2f a = %f\n", x / 2, a);
            } else if (x / 2 == 0.2) {
                b = 1.0/tan(x*x);
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2 = %.2f a = %f\n", x / 2, a);
            } else System.out.printf("При x/2 = %.2f вычисления не определены\n", x / 2);
        }
    }
}

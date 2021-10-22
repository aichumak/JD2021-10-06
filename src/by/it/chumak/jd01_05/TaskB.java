package by.it.chumak.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        final double deltaX = 0.2;
        double y;

        for (double a = 0; a <= 2; a += deltaX) {
            y = 0;
            for (double x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При a=%3.2f Сумма y = %e\n", a, y);
        }
    }

    private static void step2() {
        final double deltaX = 0.5;
        double a, betta;

        for (double x = -6; x < 2; x += deltaX) {
            if (-6 < x && x < 2) {
                betta = 0;
                a = 0;
                if (-2 < x / 2 && x / 2 <= -1) {
                    betta = sin(pow(x, 2));
                    a = log10(abs(betta + 2.74));
                    System.out.printf("При x/2=%3.2f a = %e\n", x / 2, a);
                } else if (-1 < x / 2 && x / 2 < 0.2) {
                    betta = cos(pow(x, 2));
                    a = log10(abs(betta + 2.74));
                    System.out.printf("При x/2=%3.2f a = %e\n", x / 2, a);
                } else if (x / 2 == 0.2) {
                    betta = tan(pow(x, 2));
                    a = log10(abs(betta + 2.74));
                    System.out.printf("При x/2=%3.2f a = %e\n", x / 2, a);
                } else {
                    System.out.printf("При x/2=%3.2f вычисления не определены\n", x / 2);
                }
            }
        }
    }
}

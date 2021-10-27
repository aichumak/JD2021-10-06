package by.it.kanaplianik.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main (String[] args) {
        step4();
        step5();
    }
    private static void step4() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <=6; x++) {
                double yx = pow(7, a) - cos(x);
                y = y + yx;
            }
            System.out.printf("При a=%f, Сумма y=%f\n", a, y);
        }
    }

    private static void step5() {
        for (double x = -5.5; x < 2; x += 0.5) {
            double xFull = x;
            double xHalf = x / 2;
            double beta = 0;
            boolean canCalculateBeta = true;
            if ((xHalf > -2) && (xHalf <= -1)) {
                beta = sin(pow(xFull, 2));
            }
            else if ((xHalf > -1) && (xHalf < 0.2)) {
                beta = cos(pow(xFull, 2));
            }
            else if (xHalf == 0.2) {
                beta = 1 / (tan(pow(xFull, 2)));
            }
            else {
                canCalculateBeta = false;
            }

            if (canCalculateBeta) {
                double a = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%f, a=%f\n", xHalf, a);
            }
            else {
                System.out.printf("При x/2=%f, невозможно выполнить\n ", xHalf);
            }
        }
    }
}

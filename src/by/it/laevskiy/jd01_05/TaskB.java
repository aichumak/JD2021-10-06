package by.it.laevskiy.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        for (double a = 0; a <= 2; a += 0.2) {
            double z = 0.0;
            for (double x = 1; x <= 6; x++) {
                z += pow(7, a) - cos(x);
            }
            System.out.printf("При a=%f z=%f\n", a, z);
        }
    }

    private static void step5() {
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x / 2 > -2 | x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x=%f b=%f a=%f\n", x, b, a);
            } else if (x / 2 > -1 | x / 2 < 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x=%f b=%f a=%f\n", x, b, a);
            } else if (x / 2 == 0.2) {
                double b = 1.0 / tan(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x=%f b=%f a=%f\n", x, b, a);
            } else {
                System.out.println("Вычисления невозможны");
            }
        }
    }
}

package by.it.brutski.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        part1();
        part2();
    }

    private static void part2() {
        for (double x = -6; x < 2; x += 0.5) {
            double a = x, b = x / 2, beta = 0;
            boolean flag = true;

            if ((b > -2) && (b <= -1)) beta = sin(pow(a, 2));
            else if ((b > -1) && (b < 0.2))  beta = cos(pow(a, 2));
            else if (b == 0.2) beta = 1 / (tan(pow(a, 2)));
            else  flag = false;

            if (flag) {
                double c = log10(abs(beta + 2.74));
                System.out.printf("При x/2=%f, a=%f \n", b, c);
            }
            else {
                System.out.printf("При x/2=%f, вычисления невозможны\n ", b);
            }
        }
    }

    private static void part1(){
        double y = 0;

        for (double a = 0; a <= 2; a += 0.2) {
            double v;
            for (int x = 1; x <= 6; x++) {
                v = pow(7, a) - cos(x);
                y += v;
            }
            System.out.printf("При a=%f Сумма y=%f%n", a, y);
        }
    }
}


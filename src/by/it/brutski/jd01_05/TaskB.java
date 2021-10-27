package by.it.brutski.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        part1();
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


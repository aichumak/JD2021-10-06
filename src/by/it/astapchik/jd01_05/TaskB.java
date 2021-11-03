package by.it.astapchik.jd01_05;
import static java.lang.Math.*;

import static java.lang.Math.exp;

public class TaskB {

    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
             for (int x = 1; x <= 6; x++){
                double part = (pow(7, a) - cos(x));
                y = part + y;
                System.out.printf("При a=%f y = %f\n", a, y);
            }
        }
    }
    private static void task2() {
        for (double x = -6; x < 2; x += 0.5){
            if (x / 2 < -2 || x / 2 <= -1) {
                double a = log10(sin(pow(x, 2)) + 2.74);
                System.out.printf("При x=%f a=%f\n", x, a);
            }
            if (x / 2 < -1 || x / 2 < 0.2) {
                double a = log10(cos(pow(x, 2)) + 2.74);
                System.out.printf("При x=%f a=%f\n", x, a);
            }
            if (x / 2 == 0.2) {
                double ctg = cos(pow(x, 2)) / sin(pow(x, 2));
                double a = log10(ctg + 2.74);
                System.out.printf("При x=%f a=%f\n", x, a);
            }
        }
    }
}


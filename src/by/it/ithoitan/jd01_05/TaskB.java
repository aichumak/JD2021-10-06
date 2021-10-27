package by.it.ithoitan.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
        double y = -3;
        double n = sin(pow(y,2));
        double s = log(abs(n+2.74))*0.43429;
        System.out.println(s);

    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            int x1 = 1;
            int x2 = 2;
            int x3 = 3;
            int x4 = 4;
            int x5 = 5;
            int x6 = 6;
            double y = pow(7, a) - cos(x1) + pow(7, a) - cos(x2) + pow(7, a) - cos(x3) + pow(7, a) - cos(x4) + pow(7, a) - cos(x5) + pow(7, a) - cos(x6);
            System.out.printf("При а=%6.2f y=%g\n", a, y);
        }

    }


    private static void step2() {


        double b = 0;

        for (double x = -2.75; x < 1; x = x + 0.25) {
            if (x > -3 && x <= -2) {
                System.out.printf("При x/2=%6.2f  вычисления не определены\n", x);
            } else if (x > -2 && x <= -1) {
                b = sin(pow((x*2), 2));
                double a = 0.43429*log(abs(b + 2.74));
                System.out.printf("При x/2=%6.2f a=%g\n", x, a);
            } else if (x > -1 && x < 0.2) {
                b = cos(pow((x*2), 2));
                double a =0.43429*log(abs(b + 2.74));
                System.out.printf("При x/2=%6.2f a=%g\n", x, a);
            } else if (x == 0.2) {
                b = 1 / tan(pow((x*2), 2));
                double a = 0.43429*log(abs(b + 2.74));
                System.out.printf("При x/2=%6.2f a=%g\n", x, a);
            } else if (x > 0.2 && x < 1) {
                System.out.printf("При x/2=%6.2f  вычисления не определены\n", x);
            }



        }
    }
}












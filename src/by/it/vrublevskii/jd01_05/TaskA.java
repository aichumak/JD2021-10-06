package by.it.vrublevskii.jd01_05;

import static java.lang.Math.*;

class TaskA {
    static final double a = 756.13;
    static final double x = 0.3;
    static final double a1 = 1.21;
    static final double b1 = 0.371;
    static final double x2 = 12.1;


    public static void main(String[] args) {
        double partOne = cos(pow((pow(x, 2) + PI / 6), 5));
        double partTwo = sqrt(x * pow(a, 3));
        double partThree = log(abs((a - 1.12 * x) / 4));
        double z = partOne - partTwo - partThree;
        System.out.printf("Ответ: %f\n", z);

        z = cos(pow((pow(x, 2) + PI / 6), 5)) - sqrt(x * pow(a, 3)) -
                log(abs((a - 1.12 * x) / 4));
        System.out.printf("Ответ: %f\n", z);

        double y = tan(pow(a1 + b1, 2)) - cbrt(a1 + 1.5) + a1 * pow(b1, 5) - b1 / log(pow(a1, 2));
        System.out.printf("Ответ: %f\n", y);

        for (double a2 = -5; a2 <= 12; a2 += 3.75) {
            double f = pow(E, a2 * x2) - 3.45 * a2;
            System.out.printf("При a = %f, f = %f", a2, f);
        }
    }


}

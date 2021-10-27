package by.it.brutski.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {

        part1();
        part2();
        part3();
    }

    private static void part1(){
        final double A = 756.13;
        final double X = 0.3;

        double z = cos(pow((pow(X, 2) + (PI / 6)), 5)) - sqrt((X * pow(A, 3))) - log(abs((A - 1.12 * X) / 4));
        System.out.println(z);
    }

    private static void part2() {
        final double A = 1.21;
        final double B = 0.371;

        double y = tan(pow(A + B, 2)) - pow(A + 1.5, 1.0 / 3) + A * pow(B, 5) - B / (log(pow(A, 2)));
        System.out.println(y);
    }

    private static void part3() {
        final double X = 12.1;

        for (double a = -5; a <= 12; a += 3.75) {
            double f = exp(a * X) - 3.45 * a;
            System.out.printf("При a=%f f=%f%n", a, f);
        }
    }
}

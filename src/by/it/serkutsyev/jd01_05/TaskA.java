package by.it.serkutsyev.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;

        double firstAction = cos(pow(x * x + PI / 6, 5));
        double secondAction = sqrt(x * pow(a, 3));
        double thirdAction = log((a - 1.12 * x) / 4);
        double z = firstAction - secondAction - thirdAction;
        System.out.printf("%5.6f\n", z);
        double k = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log((a - 1.12 * x) / 4);
        System.out.printf("%5.6f\n", k);

    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double z = tan(pow((a + b), 2)) - pow((a + 1.5), 1.0 / 3) + a * pow(b, 5) - b / (log(pow(a, 2)));
        System.out.printf("%5.6f\n", z);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12 ; a+=3.75) {
           // i++;
            double f = pow(E,(a*x))-3.45*a;
            //System.out.printf("%10d%10.5f",a,f);
           System.out.print(a+" ");
            System.out.println(f);
        }
    }
}

package by.it.fomin.jd01_05;



import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        task4();

    }

    private static void task4() {
        for (double x = 1.0; x <= 6.0; x += 1.0) {
            for (double a = 0; a <= 2.0; a += 0.2) {
                double y = pow(7, a)-cos(x);

                System.out.printf("При х=%f a=%f y=%f\n", x,a,y);
            }
        }
    }
}

package by.it.vrublevskii.jd01_05;

import static java.lang.Math.*;

class TaskB {
    public static void main(String[] args) {
        step4();
    }


    static void step4() {
        double sum = 0;
        double a;
        double y = 0;
        for (a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                sum += pow(7, a) - cos(x);
            }
            System.out.printf("При а = %.2f Сумма у = %f\n", a, sum);
        }
    }
}

package by.it.vrublevskii.jd01_05;

import static java.lang.Math.*;

class TaskB {
    static void main(String[] args) {

    }

    static void step4() {
        double sum = 0;
        for (int a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                sum += pow(7, a) - cos(x);
            }
        }

    }

}

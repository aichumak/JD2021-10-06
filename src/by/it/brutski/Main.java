package by.it.brutski;

import static java.lang.Math.*;

class Main {
    public static void main(String[] args) {
        double y = 0;
        for (int x = 1; x <= 6; x++) {
            double v = pow(7, 0) - cos(x);
            y += v;
        }
        System.out.println(y);
    }
}
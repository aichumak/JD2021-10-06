package by.it.brutski.jd01_10;

public class Bean {
    @Param(a = 5, b = 3)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 5, b = 3)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 5, b = 3)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    double max(int a, int b) {
        return a > b ? a : b;
    }
}

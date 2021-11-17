package by.it.konon.jd01_10;

public class Bean {

    @Param(a = 4, b = 6)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 4, b = 6)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 4, b = 6)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    double min(int a, int b) {
        return Math.min(a, b);
    }
}


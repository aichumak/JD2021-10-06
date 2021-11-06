package by.it.chumak.jd01_10;

public class Bean {

    @Param(a = 5, b = 10)
    static double sum(int a, int b) {
        return (double) a + b;
    }

    @Param(a = 5, b = 10)
    double max(int a, int b) {
        return (double) Math.max(a, b);
    }

    @Param(a = 5, b = 10)
    static double min(int a, int b) {
        return (double) Math.min(a, b);
    }

    double avg(int a, int b) {
        return (double) (a + b) / 2;
    }

}

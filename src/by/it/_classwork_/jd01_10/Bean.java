package by.it._classwork_.jd01_10;

public class Bean {

    @Param(a = 10, b = 20)
    static double sum(int left, int right) {
        return left + right;
    }

    @Param(a = 10, b = 20)
    double avg(int left, int right) {
        return (left + right) / 2.0;
    }

    @Param(a = 10, b = 20)
    static double min(int left, int right) {
        return Math.min(left, right);
    }

    double max(int left, int right) {
        return Math.max(left, right);
    }
}

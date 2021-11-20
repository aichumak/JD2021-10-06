package by.it.vrublevskii.jd01_10;

public class Bean {
    @SuppressWarnings("unused")
    @Param(a = 10, b = 20)
    static double sum(int left, int right) {
        return left + right;
    }

    @SuppressWarnings("unused")
    @Param(a = 10, b = 20)
    double avg(int left, int right) {
        return (left + right) / 2d;
    }

    @SuppressWarnings("unused")
    @Param(a = 10, b = 20)
    static double min(int left, int right) {
        return Math.min(left, right);
    }

    @SuppressWarnings("unused")
    double max(int left, int right) {
        return Math.max(left, right);
    }

}

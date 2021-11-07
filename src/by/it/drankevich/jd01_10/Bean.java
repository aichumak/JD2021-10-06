package by.it.drankevich.jd01_10;

public class Bean {

    @Param(a = 2, b = 9)
    static double sum(int a, int b) {

        return a + b;
    }

    @Param(a = 2, b = 6)
    static double max(int a, int b) {

        return Math.max(a, b);

    }

    @Param(a = 1, b = 5)
    double min(int a, int b) {

        return Math.min(a, b);
    }

    double avg(int a, int b) {

        return (a + b) / 2.0;
    }


}





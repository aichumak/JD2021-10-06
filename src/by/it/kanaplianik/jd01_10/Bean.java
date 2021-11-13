package by.it.kanaplianik.jd01_10;

public class Bean {

    @Param (a=3, b=7)
    public double sum (int a, int b) {
        return a+b;
    }

    @Param (a=3, b=7)
    static double max (int a, int b) {
        if (a>b) {
            return a;
        }
        else {
            return b;
        }
    }

    static double min (int a, int b) {
        if (a<b) {
            return a;
        }
        else {
            return b;
        }
    }

    @Param (a=3, b=7)
    public double avg (int a, int b) {
        return (a+b)/2.0;
    }

}


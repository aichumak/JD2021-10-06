package by.it.serkutsyev.jd01_10;

public class Bean {

@Param(a = 5, b = 10)
    static double sum (int a, int b){
double result = a+b;
return result;
    }
    @Param(a = 10, b = 25)
    static double max (int a, int b){
        if (a>b){
            return a;
        }
        else {
            return b;
        }
    }
    @Param(a=20,b=15)
    double min (int a, int b){
        if (a>b){
            return b;
        }
        else {
            return a;
        }
    }

    double avg (int a, int b){
        double result = ((double) a+ (double) b)/2;
        return result;
    }


}
